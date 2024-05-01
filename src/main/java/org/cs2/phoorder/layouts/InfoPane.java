package org.cs2.phoorder.layouts;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import org.cs2.phoorder.PhoOrderDriver;
import org.cs2.phoorder.components.Heading;
import org.cs2.phoorder.components.PButton;
import org.cs2.phoorder.components.PScrollPane;
import org.cs2.phoorder.models.Address;
import org.cs2.phoorder.models.Customer;
import org.cs2.phoorder.utils.Palette;
import org.cs2.phoorder.components.InputWithLabel;

/**
 * InfoPane is a VBox that displays a form for the user to enter their information.
 * includes fields for first name, last name, email, phone number, street number, apt, city, state, and additional shipping information.
 * contains buttons to proceed to payment or cancel the order.
 * if user enters invalid information, an error message will be displayed.
 * if the user cancels the order, the order will be cleared and the user will be redirected to the menu.
 * if the user proceeds to payment, the user's information will be saved and the user will be redirected to the payment pane.
 * @author Tram Nguyen
 * @version 5/01/24
 */
public class InfoPane extends VBox {
    private final Customer customer;
    private final InputWithLabel firstName;
    private final InputWithLabel lastName;
    private final InputWithLabel email;
    private final InputWithLabel phoneNumber;
    private final InputWithLabel streetNumber;
    private final InputWithLabel apt;
    private final InputWithLabel city;
    private final InputWithLabel state;
    private final InputWithLabel addShippingInfo;
    private String error;

    /**
     * Constructor for InfoPane
     */
    public InfoPane() {
        this.customer = PhoOrderDriver.order.getCustomer();
        Address address = customer.getAddress();
        int spacingHBox = 20;

        firstName = new InputWithLabel(
                "First Name",
                "Enter your first name"
        );
        firstName.setText(customer.getFirstName());

        lastName = new InputWithLabel(
                "Last Name",
                "Enter your last name"
        );
        lastName.setText(customer.getLastName());

        HBox nameBox = new HBox();
        nameBox.getChildren().addAll(
                firstName,
                lastName
        );
        nameBox.setSpacing(spacingHBox);

        email = new InputWithLabel(
                "Email",
                "Enter your email"
        );
        email.setText(customer.getEmail());

        phoneNumber = new InputWithLabel(
                "Phone Number",
                "Enter your phone number"
        );
        phoneNumber.setText(customer.getPhone());

        streetNumber = new InputWithLabel(
                "Street Number",
                "Enter your street number"
        );
        streetNumber.setText(address.getStreet());

        apt = new InputWithLabel(
                "Apt",
                "Enter your apt number"
        );
        apt.setText(address.getApt());

        HBox streetNAptBox = new HBox();
        streetNAptBox.getChildren().addAll(
                streetNumber,
                apt
        );
        streetNAptBox.setSpacing(spacingHBox);

        city = new InputWithLabel(
                "City",
                "Enter your city"
        );
        city.setText(address.getCity());

        state = new InputWithLabel(
                "State",
                "Enter your state"
        );
        state.setText(address.getState());

        HBox cityNStateBox = new HBox();
        cityNStateBox.getChildren().addAll(
                city,
                state
        );
        cityNStateBox.setSpacing(spacingHBox);

        addShippingInfo = new InputWithLabel(
                "Additional Shipping Info",
                "Enter any additional shipping information"
        );
        addShippingInfo.setText(address.getAddShippingInfo());

        Heading infoLabel = new Heading("Enter your information");
        infoLabel.setStyle(
                infoLabel.getStyle() +
                        "-fx-font-size: 30;");
        HBox.setHgrow(firstName, Priority.ALWAYS);
        HBox.setHgrow(lastName, Priority.ALWAYS);
        HBox.setHgrow(streetNumber, Priority.ALWAYS);
        HBox.setHgrow(apt, Priority.ALWAYS);
        HBox.setHgrow(city, Priority.ALWAYS);
        HBox.setHgrow(state, Priority.ALWAYS);

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
                email,
                phoneNumber,
                streetNAptBox,
                cityNStateBox,
                addShippingInfo,
                buttons
        );
        contentBox.setBackground(new Background(
                new BackgroundFill(
                        Palette.getColor("base"),
                        null,
                        null)
        ));
        contentBox.setSpacing(10);
        contentBox.setPadding(new Insets(20, 150, 50, 150));
        PScrollPane scrollPane = new PScrollPane(contentBox);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(scrollPane);
    }

    /**
     * is called when the user clicks the "To Payment" button.
     * if the form is valid, save the info and redirected to the payment pane.
     * if the form is invalid, displayed error message
     */
    public void onToPaymentClick() {
        if (isFormValid()) {
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
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing or invalid information");
            alert.setHeaderText("Invalid information");
            alert.setContentText(error);
            alert.showAndWait();
        }
    }

    /**
     * this method is for validating the form inputs
     * displays an error message if any part of the form is invalid
     * @return true if the form is valid, false otherwise
     */
    public boolean isFormValid() {
        if (!isValidName()) {
            error = "Please enter a valid name";
            return false;
        } else if (!isValidEmail()) {
            error = "Please enter a valid email";
            return false;
        } else if (!isValidPhone()) {
            error = "please enter a valid phone number";
            return false;
        } else if (streetNumber.getText().isEmpty()) {
            error = "Please enter a valid street number";
            return false;
        } else if (city.getText().isEmpty()) {
            error = "Please enter a valid city";
            return false;
        } else if (state.getText().isEmpty()) {
            error = "Please enter a valid state";
            return false;
        }
        return true;
    }

    /**
     * this method is for validating the name input
     * @return true if the name is valid, false otherwise
     */
    public boolean isValidName() {
        //no numbers allowed in name
        return (
                firstName.getText().trim().matches("^[a-zA-Z]*$") &&
                lastName.getText().trim().matches("^[a-zA-Z]*$")
        );
    }

    /**
     * this method is for validating the email input
     * @return true if the email is valid, false otherwise
     */
    public boolean isValidEmail() {
        return email.getText().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    /**
     * this method is for validating the phone number input
     * @return true if the phone number is valid, false otherwise
     */
    public boolean isValidPhone() {
        return phoneNumber.getText().matches("^[0-9]{10}$");
    }

    /**
     * is called when the user clicks the "Cancel Order" button
     * clears the order and redirects menu pane
     */
    public void onCancelOrderClick() {
        PhoOrderDriver.order.clear();
        PhoOrderDriver.root.updateCenter("menu");
    }
}