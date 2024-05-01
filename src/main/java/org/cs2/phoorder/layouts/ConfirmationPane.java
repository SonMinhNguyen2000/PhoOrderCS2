package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Address;
import org.cs2.phoorder.models.Customer;
import org.cs2.phoorder.models.Order;
import org.cs2.phoorder.models.PaymentMethod;

/**
 * ConfirmationPane is a VBox that displays the order confirmation information.
 * It displays the customer's name, email, phone number, address, payment information, and total price of the order.
 * It also contains buttons to confirm or cancel the order.
 * @author Tram Nguyen
 * @version 5/01/24
 */
public class ConfirmationPane extends VBox {
    public ConfirmationPane() {
        Order order = PhoOrderDriver.order;
        Customer customer = order.getCustomer();
        Address address = customer.getAddress();
        PaymentMethod payment = customer.getPaymentMethod();
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));

        Heading titleLabel = new Heading("Order Confirmation");
        titleLabel.setStyle(
                titleLabel.getStyle() +
                "-fx-font-size: 24; "
        );

        // Display customer information
        Label nameLabel = new Label("Name: " + customer.getFirstName() + " " + customer.getLastName());
        Label emailLabel = new Label("Email: " + customer.getEmail());
        Label phoneNumberLabel = new Label("Phone Number: " + customer.getPhone());

        // Display address information
        Label addressLabel = new Label("Address: " + address.getStreet() + ", " + address.getCity() + ", " +
                address.getState() + ", " + address.getApt());

        // Display payment information
        Label cardNumberLabel = new Label("Card Number: " + payment.getCardNumber());
        Label cardNameLabel = new Label("Card Name: " + payment.getCardName());
        Label expDateLabel = new Label("Expiration Date: " + payment.getExpirationDate());
        Label totalLabel = new Label(String.format("Total: $%.2f", order.getTotal()));

        // Create confirmation and cancel buttons
        PButton confirmButton = new PButton("tertiary", "Confirm Order");
        confirmButton.setOnAction(event -> {
            System.out.println("Order confirmed!");
            // Close the confirmation pane
            getScene().getWindow().hide();
        });

        PButton cancelButton = new PButton("secondary", "Cancel");
        cancelButton.setOnAction(event -> {
            // Handle cancellation logic
            // For example, close the window without confirming the order
            System.out.println("Order canceled.");
            // Close the confirmation pane
            getScene().getWindow().hide();
        });
        VBox confirmInfo = new VBox();
        confirmInfo.getChildren().addAll(
                nameLabel,
                emailLabel,
                phoneNumberLabel,
                addressLabel,
                cardNumberLabel,
                cardNameLabel,
                expDateLabel,
                totalLabel
        );
        confirmInfo.setStyle(
                "-fx-font-weight: bold;" +
                "-fx-font-family: 'Inter';" +
                "-fx-font-size: 18;"
        );
        confirmInfo.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(
                titleLabel,
                confirmInfo,
                confirmButton,
                cancelButton
        );
    }

    public void onConfirmClick() {
        PhoOrderDriver.root.updateCenter("menu");
        PhoOrderDriver.order.clear();
    }

    public void onCancelClick() {
        PhoOrderDriver.root.updateCenter("menu");
        PhoOrderDriver.order.clear();
    }
}