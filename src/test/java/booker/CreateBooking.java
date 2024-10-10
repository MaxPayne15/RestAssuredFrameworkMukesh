package booker;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class CreateBooking {

    @Test
    public void createBooking() {

        String endPoint = "https://restful-booker.herokuapp.com/booking";
        Map<String, Object> payload = Payloads.getCreateBookingPayloadFromMap("Mukesh","Suthar","150", "true", "2024-10-12", "2024-10-15", "Breakfast, lunch & dinner");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
