package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.Input;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.PaymentMethod;
import org.cs2.phoorder.utils.Palette;

public class PaymentPane extends VBox{
    private PaymentMethod payment;
    private Input cardNumber;
    private Input cardName;
    private Input expDate;
    private Input cvv;
    private Input billingAddress;

    public PaymentPane() {
        int spacingVBox = 10;
        int spacingHBox = 20;
        this.payment = PhoOrderDriver.order.getCustomer().getPaymentMethod();

        VBox cardNumberBox = new VBox();
        Heading cardNumberLabel = new Heading("Card Number");
        cardNumberLabel.setStyle(
                cardNumberLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.cardNumber = new Input("Enter your card number");
        this.cardNumber.setText(payment.getCardNumber());
        cardNumberBox.getChildren().addAll(
                cardNumberLabel,
                this.cardNumber
        );
        cardNumberBox.setSpacing(spacingVBox);

        VBox cardNameBox = new VBox();
        Heading cardNameLabel = new Heading("Card Name");
        cardNameLabel.setStyle(
                cardNameLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.cardName = new Input("Enter your card name");
        this.cardName.setText(payment.getCardName());
        cardNameBox.getChildren().addAll(
                cardNameLabel,
                this.cardName
        );
        cardNameBox.setSpacing(spacingVBox);

        VBox expDateBox = new VBox();
        Heading expDateLabel = new Heading("Expiration Date");
        expDateLabel.setStyle(
                expDateLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.expDate = new Input("Enter your expiration date");
        this.expDate.setText(payment.getExpirationDate());
        expDateBox.getChildren().addAll(
                expDateLabel,
                this.expDate
        );
        expDateBox.setSpacing(spacingVBox);

        VBox cvvBox = new VBox();
        Heading cvvLabel = new Heading("CVV");
        cvvLabel.setStyle(
                cvvLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.cvv = new Input("Enter your CVV");
        this.cvv.setText(payment.getCvv());
        cvvBox.getChildren().addAll(
                cvvLabel,
                this.cvv
        );
        cvvBox.setSpacing(spacingVBox);

        HBox expDateNCvvBox = new HBox();
        expDateNCvvBox.getChildren().addAll (
                expDateBox,
                cvvBox
        );
        expDateNCvvBox.setSpacing(spacingHBox);

        VBox billingAddressBox = new VBox();
        Heading billingAddressLabel = new Heading("Billing Address");
        billingAddressLabel.setStyle(
                billingAddressLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.billingAddress = new Input("Enter your billing address");
        this.billingAddress.setText(payment.getBillingAddress());
        billingAddressBox.getChildren().addAll(
                billingAddressLabel,
                this.billingAddress
        );
        billingAddressBox.setSpacing(spacingVBox);

// Buttons initialization
        PButton next = new PButton("tertiary", "Next");
        next.setOnAction(e -> {
            onNextClick();
        });

        PButton cancelOrder = new PButton("secondary", "Cancel Order");
        cancelOrder.setOnAction(e -> {
            onCancelOrderClick();
        });

        HBox buttons = new HBox(cancelOrder, next);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);


        // Layout setup
        HBox.setHgrow(expDateBox, Priority.ALWAYS);
        HBox.setHgrow(cvvBox, Priority.ALWAYS);
        Heading infoLabel = new Heading("Payment Method");
        VBox contentBox = new VBox();
        infoLabel.setStyle(
                infoLabel.getStyle() +
                        "-fx-font-size: 30;");
        contentBox.getChildren().addAll(
                infoLabel,
                cardNumberBox,
                expDateNCvvBox,
                billingAddressBox,
                buttons
        );
        contentBox.setBackground(new Background(
                new BackgroundFill(
                        Palette.getColor("base"),
                        null,
                        null)
        ));
        contentBox.setSpacing(20);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(contentBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent;"
        );
        this.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(20, 150, 50, 150));
        this.getChildren().add(scrollPane);
    }


    private void onNextClick() {
        if (!isFormFilled()) {
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
            alert.showAndWait();
        }
    }

    private boolean isFormFilled() {
        return validateCardName() ||
                validateCardNumber() ||
                validateExpDate() ||
                validateCvv() ||
                billingAddress.getText().isEmpty();
    }

    private boolean validateCardNumber() {
        return cardNumber.getText().matches("^[0-9]{16}$");
    }

    private boolean validateCardName() {
        return cardName.getText().matches("^[a-zA-Z ]+$");
    }

    private boolean validateExpDate() {
        return expDate.getText().matches("^(0[1-9]|1[0-2])\\/[0-9]{2}$");
    }

    private boolean validateCvv() {
        return cvv.getText().matches("^[0-9]{3}$");
    }

    private void onCancelOrderClick() {
        PhoOrderDriver.order.clear();
        PhoOrderDriver.root.updateCenter("menu");
    }

    private void updateInfo(){
        payment.setCardNumber(cardNumber.getText());
        payment.setCardName(cardName.getText());
        payment.setExpirationDate(expDate.getText());
        payment.setCvv(cvv.getText());
        payment.setBillingAddress(billingAddress.getText());
    }
}

