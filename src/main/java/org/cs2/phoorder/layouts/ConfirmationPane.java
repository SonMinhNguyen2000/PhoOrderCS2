package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Address;
import org.cs2.phoorder.models.Customer;
import org.cs2.phoorder.models.PaymentMethod;
import org.cs2.phoorder.utils.Palette;

public class ConfirmationPane extends VBox {
private Customer customer;
private Address address;
private PaymentMethod payment;
    public ConfirmationPane() {
        customer = PhoOrderDriver.order.getCustomer();
        address = customer.getAddress();
        payment = customer.getPaymentMethod();
        //customer.onToPaymentClick();
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setPadding(new Insets(20));

        Label titleLabel = new Label("Order Confirmation");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

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

        // Add components to the layout
        getChildren().addAll(
                titleLabel,
                nameLabel,
                emailLabel,
                phoneNumberLabel,
                addressLabel,
                cardNumberLabel,
                cardNameLabel,
                expDateLabel,
                confirmButton,
                cancelButton
        );
    }
}