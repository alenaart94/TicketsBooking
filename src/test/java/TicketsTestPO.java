import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class TicketsTestPO {

    //private BaseFunc baseFunc = new BaseFunc(); - mozhno zdesj, am mozhno vnutri testa

    @Test
    public void poTest() {
        BaseFunc baseFunc = new BaseFunc(); //ispoljzuetsja toljko vnutri etogo klassa

        baseFunc.goToUrl("http://qaguru.lv:8089/tickets/");

        //Sozdatj kopiju page, chtobi ponjatj, chto mi na nej nahodimsja (mi serjchas na HomePage)
        HomePage homePage = new HomePage(baseFunc);
        String brandNameHP = homePage.getBrandNameHP();

        String departureNameHP = "RIX";
        String arrivalNameHP = "SVO";

        homePage.selectDeparture(departureNameHP);
        homePage.selectArrival(arrivalNameHP);
        homePage.pressGoGoGo();

        BookingPage bookingPage = new BookingPage(baseFunc);
        String brandNameBP = bookingPage.getBrandNameBP();

       //Assertions.assertEquals(brandNameHP, brandNameBP, "not equal" );
        String departureNameBP = bookingPage.getDeparture();
        String arrivalNameBP = bookingPage.getArrival();

        Assertions.assertEquals(departureNameHP, departureNameBP, "Departure name in Booking page is not same as in Home Page");
        Assertions.assertEquals(arrivalNameHP, arrivalNameBP, "Arrival name in Booking Page is not same as in Home Page");

        String customerName = "Alena";
        String customerSurname = "Artemova";
        String discountCode = "10RIX";
        String adultCount = "1";
        String childrenCount = "0";
        String luggageCount = "1";
        String flightDate = "15-05-2018";

        bookingPage.enterCustomerName(customerName);
        bookingPage.enterCustomerSurname(customerSurname);
        bookingPage.enterDiscountCode(discountCode);
        bookingPage.enterAdultCount(adultCount);
        bookingPage.enterChildrenCount(childrenCount);
        bookingPage.enterLuggageCount(luggageCount);
        bookingPage.selectNextFlight(flightDate);
        bookingPage.pressBookButton();

        BookSeatPage bookSeatPage = new BookSeatPage(baseFunc);
        String seatToChoose = "7";

        bookSeatPage.selectSeat(seatToChoose);

        ChosenSeatPage chosenSeatPage = new ChosenSeatPage(baseFunc);

        String chosenSeat = chosenSeatPage.getChosenSeat();

        Assertions.assertEquals(seatToChoose, chosenSeat, "Chosen seat value is not correct");

        chosenSeatPage.pressBookButton();

        BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage(baseFunc);
        String confirmationMessage = "Thank You for flying with us!";
        String confirmationMessageBCP = bookingConfirmationPage.getBookingConfirmation();

        Assertions.assertEquals(confirmationMessage, confirmationMessageBCP, "Confirmation massage is different than expected");

    }

}
