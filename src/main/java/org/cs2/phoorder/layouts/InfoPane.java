package org.cs2.phoorder.layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.Input;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.models.Address;
import org.cs2.phoorder.models.Customer;
import org.cs2.phoorder.utils.Palette;

public class InfoPane extends VBox {
    private Address address;
    private Customer customer;
    private Input firstName;
    private Input lastName;
    private Input email;
    private Input phoneNumber;
    private Input streetNumber;
    private Input apt;
    private Input city;
    private Input state;
    private Input addShippingInfo;

    public InfoPane() {
        this.customer = PhoOrderDriver.order.getCustomer();
        this.address = customer.getAddress();
        int spacingVBox = 10;
        int spacingHBox = 20;

        VBox firstNameBox = new VBox();
        firstNameBox.setSpacing(spacingVBox);
        Heading firstNameLabel = new Heading("First Name");
        firstNameLabel.setStyle(
                firstNameLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.firstName = new Input("Enter your first name");
        this.firstName.setText(customer.getFirstName());
        firstNameBox.getChildren().addAll(
                firstNameLabel,
                this.firstName
        );

        VBox lastNameBox = new VBox();
        lastNameBox.setSpacing(spacingVBox);
        Heading lastNameLabel = new Heading("First Name");
        lastNameLabel.setStyle(
                lastNameLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.lastName = new Input("Enter your last name");
        lastName.setText(customer.getLastName());
        lastNameBox.getChildren().addAll(
                lastNameLabel,
                this.lastName
        );

        HBox nameBox = new HBox();
        nameBox.getChildren().addAll(
                firstNameBox,
                lastNameBox
        );
        nameBox.setSpacing(spacingHBox);

        VBox emailBox = new VBox();
        Heading emailLabel = new Heading("Email");
        emailLabel.setStyle(
                emailLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.email = new Input("Enter your email address");
        email.setText(customer.getEmail());
        emailBox.getChildren().addAll(
                emailLabel,
                this.email
        );
        emailBox.setSpacing(spacingVBox);

        VBox phoneNumberBox = new VBox();
        Heading phoneNumberLabel = new Heading("Phone Number");
        phoneNumberLabel.setStyle(
                phoneNumberLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.phoneNumber = new Input("Enter your phone number");
        phoneNumber.setText(customer.getPhone());
        phoneNumberBox.getChildren().addAll(
                phoneNumberLabel,
                this.phoneNumber
        );
        phoneNumberBox.setSpacing(spacingVBox);

        VBox streetNumberBox = new VBox();
        Heading streetNumberLabel = new Heading("Street No");
        streetNumberLabel.setStyle(
                streetNumberLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.streetNumber = new Input("Enter your street num");
        streetNumber.setText(address.getStreet());
        streetNumberBox.getChildren().addAll(
                streetNumberLabel,
                this.streetNumber
        );
        streetNumberBox.setSpacing(spacingVBox);

        VBox aptBox = new VBox();
        Heading aptLabel = new Heading("Apt");
        aptLabel.setStyle(
                aptLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.apt = new Input("Enter your apt no");
        apt.setText(address.getApt());
        aptBox.getChildren().addAll(
                aptLabel,
                this.apt
        );
        aptBox.setSpacing(spacingVBox);

        HBox streetNAptBox = new HBox();
        streetNAptBox.getChildren().addAll(
                streetNumberBox,
                aptBox
        );
        streetNAptBox.setSpacing(spacingHBox);

        VBox cityBox = new VBox();
        Heading cityLabel = new Heading("City");
        cityLabel.setStyle(
                cityLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.city = new Input("Enter your city");
        city.setText(address.getCity());
        cityBox.getChildren().addAll(
                cityLabel,
                this.city
        );
        cityBox.setSpacing(spacingVBox);

        VBox stateBox = new VBox();
        Heading stateLabel = new Heading("State");
        stateLabel.setStyle(
                stateLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.state = new Input("Enter your state");
        state.setText(address.getState());
        stateBox.getChildren().addAll(
                stateLabel,
                this.state
        );
        stateBox.setSpacing(spacingVBox);

        HBox cityNStateBox = new HBox();
        cityNStateBox.getChildren().addAll(
                cityBox,
                stateBox
        );
        cityNStateBox.setSpacing(spacingHBox);

        VBox addShippingInfoBox = new VBox();
        Heading addShippingInfoLabel = new Heading("Additional Shipping Info");
        addShippingInfoLabel.setStyle(
                stateLabel.getStyle() +
                        "-fx-font-size: 16;");
        this.addShippingInfo = new Input("Tell us if you have any additional info");
        addShippingInfo.setText(address.getAddShippingInfo());
        addShippingInfoBox.getChildren().addAll(
                addShippingInfoLabel,
                this.addShippingInfo
        );
        addShippingInfoBox.setSpacing(spacingVBox);

        Heading infoLabel = new Heading("Enter your information");
        infoLabel.setStyle(
                infoLabel.getStyle() +
                        "-fx-font-size: 30;");
        HBox.setHgrow(firstNameBox, Priority.ALWAYS);
        HBox.setHgrow(lastNameBox, Priority.ALWAYS);
        HBox.setHgrow(streetNumberBox, Priority.ALWAYS);
        HBox.setHgrow(aptBox, Priority.ALWAYS);
        HBox.setHgrow(cityBox, Priority.ALWAYS);
        HBox.setHgrow(stateBox, Priority.ALWAYS);

        PButton toPayment = new PButton("tertiary", "To Payment");
        toPayment.setOnAction(e -> {
            onToPaymentClick();
        });
        PButton cancelOrder = new PButton("secondary", "Cancel Order");
        cancelOrder.setOnAction(e -> {
            onCancelOrderClick();
        });
        HBox buttons = new HBox(cancelOrder, toPayment);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);
        VBox contentBox = new VBox();
        contentBox.getChildren().addAll(
                infoLabel,
                nameBox,
                emailBox,
                phoneNumberBox,
                streetNAptBox,
                cityNStateBox,
                addShippingInfoBox,
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

    public void onToPaymentClick() {
        if (isFormFilled()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill out all the required field!");
            alert.showAndWait();
        } else {
            Address currAddress = new Address(
                    streetNumber.getText(),
                    city.getText(),
                    state.getText(),
                    addShippingInfo.getText());
            currAddress.setApt(apt.getText());
            this.customer.setFirstName(firstName.getText());
            this.customer.setLastName(lastName.getText());
            this.customer.setEmail(email.getText());
            this.customer.setAddress(currAddress);
            this.customer.setPhone(phoneNumber.getText());
            PhoOrderDriver.root.updateCenter("payment");
        }
    }

    public boolean isFormFilled() {
                return (!validateName() ||
                        !validateEmail() ||
                        streetNumber.getText().isEmpty() ||
                        city.getText().isEmpty() ||
                        state.getText().isEmpty());
    }

    public boolean validateName() {
        return firstName.getText().matches("^[a-zA-Z ]+$") ||
                lastName.getText().matches("^[a-zA-Z ]+$");
    }

    public boolean validateEmail() {
        return email.getText().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    public boolean validatePhone() {
        return phoneNumber.getText().matches("^[0-9]{10}$");
    }

    public void onCancelOrderClick() {
        PhoOrderDriver.order.clear();
        PhoOrderDriver.root.updateCenter("menu");
    }
}