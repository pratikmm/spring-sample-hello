package hello;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity testhello(){


        String json = "{'status': 'success','code':'OK'}";
        return new ResponseEntity<>(json, HttpStatus.OK);

    }

}
