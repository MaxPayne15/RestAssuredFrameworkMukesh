package booker;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateBooking {

    @Test
    public void createBooking() throws IOException {

        //System.out.println(System.getProperty("env") + ": Environment Value" );
        String env = System.getProperty("env") == null ? "prod" : System.getProperty("env");
        Map<String, String> data = JsonUtils.getJsonDataAsMap("/booker/"+env+"/bookerAPIData.json");
        String endPoint = data.get("createBookingEndpoint");
        Map<String, Object> payload = Payloads.getCreateBookingPayloadFromMap("Mukesh","Suthar","150", "true", "2024-10-12", "2024-10-15", "Breakfast, lunch & dinner");
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
