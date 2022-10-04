package com.sandhills.sandhills.controller;

import com.sandhills.sandhills.model.Courses;
import com.sandhills.sandhills.model.ResponseMessage;
import com.sandhills.sandhills.model.Enrollment;
import com.sandhills.sandhills.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CondiutController {

    private final RestTemplate restTemplate;

    @Value("${courses.url}")
    private String COURSE_URL;

    @Value("${users.url}")
    private String USER_URL;

    @Value("${enrollment.url}")
    private String ENROLLMENT_URL;

    @Value("${token}")
    private String TOKEN;

    public CondiutController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(path = "/course"
            , method = RequestMethod.POST
            //,produces = {"application/xml"}
    )
    public //@ResponseBody
    ResponseMessage postCourses(@RequestBody Courses courses)  throws Exception {

        String flat_xml="";

        String shortname1=courses.getShortname();;
        String category1=courses.getCategory();
       // String password1=courses.getPassword();
        String fullname1=courses.getFullname();
        String idnumber1=courses.getIdnumber();
        String summary1=courses.getSummary();
        Integer summaryformat1=courses.getSummaryformat();
        String format1=courses.getFormat();
        Integer showgrades1=courses.getShowgrades();
        Integer newsitems1=courses.getNewsitems();
        Integer startdate1=courses.getStartdate();
        Integer numsections1=courses.getNumsections();
        Integer marker1=courses.getMarker();
        Integer maxbytes1=courses.getMaxbytes();
        Integer showreports1=courses.getShowreports();
        Integer visible1=courses.getVisible();
        Integer hiddensections1=courses.getHiddensections();
        Integer groupmode1=courses.getGroupmode();
        Integer groupmodeforce1=courses.getGroupmodeforce();
        Integer defaultgroupingid1=courses.getDefaultgroupingid();
        String lang1=courses.getLang();
        String theme1=courses.getTheme();
        Integer requested1=courses.getRequested();
        Integer restrictmodules1=courses.getRestrictmodules();
        Integer enablecompletion1=courses.getEnablecompletion();
        Integer completionstartonenrol1=courses.getCompletionstartonenrol();
        Integer completionnotify1=courses.getCompletionnotify();
        String coursetemplate1=courses.getCoursetemplate();

       // flat_xml=shortname1+" , "+category1+" , "+password1+" , "+fullname1;
       flat_xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data>"+
            "<datum action=\"create\">"+
            "<mapping name=\"shortname\">"+shortname1+"</mapping>"+
            "<mapping name=\"category\">"+category1+"</mapping>"+
           // "<mapping name=\"password\">"+password1+"</mapping>"+
            "<mapping name=\"fullname\">"+fullname1+"</mapping>"+
            "<mapping name=\"idnumber\">"+idnumber1+"</mapping>"+
            "<mapping name=\"summary\">"+summary1+"</mapping>"+
            "<mapping name=\"summaryformat\">"+summaryformat1+"</mapping>"+
            "<mapping name=\"format\">"+format1+"</mapping>"+
            "<mapping name=\"showgrades\">"+showgrades1+"</mapping>"+
            "<mapping name=\"newsitems\">"+newsitems1+"</mapping>"+
            "<mapping name=\"startdate\">"+startdate1+"</mapping>"+
            "<mapping name=\"numsections\">"+numsections1+"</mapping>"+
            "<mapping name=\"marker\">"+marker1+"</mapping>"+
            "<mapping name=\"maxbytes\">"+maxbytes1+"</mapping>"+
            "<mapping name=\"showreports\">"+showreports1+"</mapping>"+
            "<mapping name=\"visible\">"+visible1+"</mapping>"+
            "<mapping name=\"hiddensections\">"+hiddensections1+"</mapping>"+
            "<mapping name=\"groupmode\">"+groupmode1+"</mapping>"+
            "<mapping name=\"groupmodeforce\">"+groupmodeforce1+"</mapping>"+
            "<mapping name=\"defaultgroupingid\">"+defaultgroupingid1+"</mapping>"+
            "<mapping name=\"lang\">"+lang1+"</mapping>"+
            "<mapping name=\"theme\">"+theme1+"</mapping>"+
            "<mapping name=\"requested\">"+requested1+"</mapping>"+
            "<mapping name=\"restrictmodules\">"+restrictmodules1+"</mapping>"+
            "<mapping name=\"enablecompletion\">"+enablecompletion1+"</mapping>"+
            "<mapping name=\"completionstartonenrol\">"+completionstartonenrol1+"</mapping>"+
            "<mapping name=\"completionnotify\">"+completionnotify1+"</mapping>"+
            "<mapping name=\"coursetemplate\">"+coursetemplate1+"</mapping>"+
            "</datum></data>";

        String request_url=COURSE_URL+"?method=handle&token="+TOKEN+"&xml="+flat_xml;

        //HttpEntity<String> httpEntity = new HttpEntity<>();

        ResponseEntity<String> response = restTemplate.exchange(request_url, HttpMethod.POST, null,String.class);

        /*
        String response_message="<Service_Course generator=\"zend\" version=\"1.0\">" +
                "<handle>" +
                "<message>"+response.getBody()+"</message>" +
                "<status>"+response.getStatusCode()+"</status>" +
                "</handle></Service_Rest_Course>";
      */
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setCode(String.valueOf(response.getStatusCode()));
        responseMessage.setMessage(response.getBody());

        return responseMessage;
    }
    @RequestMapping(path = "/user"
            , method = RequestMethod.POST
            //,produces = {"application/xml"}
    )
    public //@ResponseBody
    ResponseMessage postUsers(@RequestBody Users users)  throws Exception {

        String flat_xml="";

        String username1=users.getUsername();
        String auth1=users.getAuth();
        String password1=users.getPassword();
        String idnumber1=users.getIdnumber();
        String firstname1=users.getFirstname();
         String lastname1=users.getLastname();
        String email1=users.getEmail();
        String maildisplay1= users.getMaildisplay();
        String city1=users.getCity();
        String country1=users.getCountry();
        String timezone1=users.getTimezone();
        String description1=users.getDescription();

        flat_xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data>"+
                "<datum action=\"create\">"+
                "<mapping name=\"username\">"+username1+"</mapping>"+
                "<mapping name=\"auth\">"+auth1+"</mapping>"+
                "<mapping name=\"password\">"+password1+"</mapping>"+
                "<mapping name=\"idnumber\">"+idnumber1+"</mapping>"+
                "<mapping name=\"firstname\">"+firstname1+"</mapping>"+
                "<mapping name=\"lastname\">"+lastname1+"</mapping>"+
                "<mapping name=\"email\">"+email1+"</mapping>"+
                "<mapping name=\"maildisplay\">"+maildisplay1+"</mapping>"+
                "<mapping name=\"city\">"+city1+"</mapping>"+
                "<mapping name=\"country\">"+country1+"</mapping>"+
                "<mapping name=\"timezone\">"+timezone1+"</mapping>"+
                "<mapping name=\"description\">"+description1+"</mapping>"+
                "</datum></data>";

        String request_url=USER_URL+"?method=handle&token="+TOKEN+"&xml="+flat_xml;

        //HttpEntity<String> httpEntity = new HttpEntity<>();

        ResponseEntity<String> response = restTemplate.exchange(request_url, HttpMethod.POST, null,String.class);

        /*
        String response_message="<Service_Course generator=\"zend\" version=\"1.0\">" +
                "<handle>" +
                "<message>"+response.getBody()+"</message>" +
                "<status>"+response.getStatusCode()+"</status>" +
                "</handle></Service_Rest_Course>";
      */
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setCode(String.valueOf(response.getStatusCode()));
        responseMessage.setMessage(response.getBody());

        return responseMessage;
    }
    @RequestMapping(path = "/enrollment"
            , method = RequestMethod.POST
            //,produces = {"application/xml"}
    )
    public //@ResponseBody
    ResponseMessage postEnrollment(@RequestBody Enrollment enrollment)  throws Exception {

        String flat_xml="";

        String courseid1=enrollment.getCourseid();
        String userid1=enrollment.getUserid();
        String roleid1=enrollment.getRoleid();
        Integer timestart1=enrollment.getTimestart();
        Integer timeend1=enrollment.getTimeend();

        flat_xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?><data>"+
                "<datum action=\"create\">"+
                "<mapping name=\"courseid\">"+courseid1+"</mapping>"+
                "<mapping name=\"userid\">"+userid1+"</mapping>"+
                "<mapping name=\"roleid\">"+roleid1+"</mapping>"+
                "<mapping name=\"timestart\">"+timestart1+"</mapping>"+
                "<mapping name=\"timeend\">"+timeend1+"</mapping>"+
                "</datum></data>";

        String request_url=ENROLLMENT_URL+"?method=handle&token="+TOKEN+"&xml="+flat_xml;

        //HttpEntity<String> httpEntity = new HttpEntity<>();

        ResponseEntity<String> response = restTemplate.exchange(request_url, HttpMethod.POST, null,String.class);

        /*
        String response_message="<Service_Course generator=\"zend\" version=\"1.0\">" +
                "<handle>" +
                "<message>"+response.getBody()+"</message>" +
                "<status>"+response.getStatusCode()+"</status>" +
                "</handle></Service_Rest_Course>";
      */
        ResponseMessage responseMessage=new ResponseMessage();
        responseMessage.setCode(String.valueOf(response.getStatusCode()));
        responseMessage.setMessage(response.getBody());

        return responseMessage;
    }
}
