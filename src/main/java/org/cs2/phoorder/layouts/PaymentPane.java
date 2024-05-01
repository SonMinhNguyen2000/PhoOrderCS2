package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.*;
import org.cs2.phoorder.models.PaymentMethod;
import org.cs2.phoorder.utils.Palette;

/**
 * PaymentPane is a VBox that displays a form for the user to enter their payment information.
 * @author Tram Nguyen
 * @version 5/01/24
 */
public class PaymentPane extends VBox{
    private final PaymentMethod payment;
    private final InputWithLabel cardNumber;
    private final InputWithLabel cardName;
    private final InputWithLabel expDate;
    private final InputWithLabel cvv;
    private final InputWithLabel billingAddress;
    private String error;

    public PaymentPane() {
        int spacingHBox = 20;
        this.payment = PhoOrderDriver.order.getCustomer().getPaymentMethod();

        cardName = new InputWithLabel(
                "Card Name",
                "Enter your card name"
        );
        cardName.setText(payment.getCardName());

        cardNumber = new InputWithLabel(
                "Card Number",
                "Enter your card number"
        );
        cardNumber.setText(payment.getCardNumber());

        expDate = new InputWithLabel(
                "Expiration Date",
                "Enter your expiration date"
        );
        expDate.setText(payment.getExpirationDate());

        cvv = new InputWithLabel(
                "CVV",
                "Enter your CVV"
        );
        cvv.setText(payment.getCvv());

        HBox expDateNCvvBox = new HBox();
        expDateNCvvBox.getChildren().addAll (
                expDate,
                cvv
        );
        expDateNCvvBox.setSpacing(spacingHBox);

        billingAddress = new InputWithLabel(
                "Billing Address",
                "Enter your billing address"
        );
        billingAddress.setText(payment.getBillingAddress());

        PButton next = new PButton("tertiary", "Next");
        next.setOnAction(e -> onNextClick());
        PButton cancelOrder = new PButton("secondary", "Cancel Order");
        cancelOrder.setOnAction(e -> onCancelOrderClick());
        HBox buttons = new HBox(cancelOrder, next);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);


        // Layout setup
        HBox.setHgrow(expDate, Priority.ALWAYS);
        HBox.setHgrow(cvv, Priority.ALWAYS);
        Heading infoLabel = new Heading("Payment Method");
        VBox contentBox = new VBox();
        infoLabel.setStyle(
                infoLabel.getStyle() +
                        "-fx-font-size: 30;");
        contentBox.getChildren().addAll(
                infoLabel,
                cardName,
                cardNumber,
                expDateNCvvBox,
                billingAddress,
                buttons
        );
        contentBox.setBackground(new Background(
                new BackgroundFill(
                        Palette.getColor("base"),
                        null,
                        null)
        ));
        contentBox.setSpacing(10);
        PScrollPane scrollPane = new PScrollPane(contentBox);
        this.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(20, 150, 50, 150));
        this.getChildren().add(scrollPane);
    }

    /**
     * Called when user clicks the "Next" button.
     * if the form is valid, updates the payment info, redirect to the confirmation pane
     * if the form is invalid, displays an error message
     */
    private void onNextClick() {
        if (isFormValid()) {
            payment.setCardNumber(cardNumber.getText());
            payment.setCardName(cardName.getText());
            payment.setExpirationDate(expDate.getText());
            payment.setCvv(cvv.getText());
            payment.setBillingAddress(billingAddress.getText());
            PhoOrderDriver.root.updateCenter("confirmation");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill out all fields correctly");
            alert.setContentText(error);
            alert.showAndWait();
        }
    }

    /**
     * Checks if all parts of the form are valid
     * @return true if the form is valid, false otherwise
     */
    private boolean isFormValid() {
        if (!isValidCardNumber()) {
            error = "Invalid card number";
            return false;
        } else if (!isValidCardName()) {
            error = "Invalid card name";
            return false;
        } else if (!isValidExpDate()) {
            error = "Invalid expiration date";
            return false;
        } else if (!isValidCvv()) {
            error = "Invalid CVV";
            return false;
        } else if (billingAddress.getText().isEmpty()) {
            error = "Billing address cannot be empty";
            return false;
        }
        return true;
    }

    /**
     * Checks if the card number is valid
     * @return true if the card number is valid, false otherwise
     */
    private boolean isValidCardNumber() {
        return cardNumber.getText().matches("^[0-9]{16}$");
    }

    /**
     * Checks if the card name is valid
     * @return true if the card name is valid, false otherwise
     */
    private boolean isValidCardName() {
        return cardName.getText().matches("^[a-zA-Z ]+$");
    }

    /**
     * Checks if the expiration date is valid
     * @return true if the expiration date is valid, false otherwise
     */
    private boolean isValidExpDate() {
        return expDate.getText().matches("^(0[1-9]|1[0-2])/[0-9]{2}$");
    }

    /**
     * Checks if the CVV is valid
     * @return true if the CVV is valid, false otherwise
     */
    private boolean isValidCvv() {
        return cvv.getText().matches("^[0-9]{3}$");
    }

    /**
     * Called when user clicks the "Cancel Order" button.
     * Clears the order and redirects to the menu pane.
     */
    private void onCancelOrderClick() {
        PhoOrderDriver.order.clear();
        PhoOrderDriver.root.updateCenter("menu");
    }
}

