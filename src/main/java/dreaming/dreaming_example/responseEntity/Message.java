package dreaming.dreaming_example.responseEntity;

import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
public class Message {
    private StatusEnum status;
    private String message;
    private Object data;

    public Message(StatusEnum status, String message, Object data) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
