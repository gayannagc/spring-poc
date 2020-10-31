package com.example.comettestproject.controllerpackage;


import com.example.comettestproject.dto.*;
import com.example.comettestproject.dto.resource.ProductOrderRef;
import com.example.comettestproject.dto.resource.SuspendResumeError;
import com.example.comettestproject.dto.tokenDto.JWTToken;
import com.example.comettestproject.entity.Role;
import com.example.comettestproject.service.TestService;
import com.example.comettestproject.service.TestStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/openapi/dummy")
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    TestStringService stringService;





    @PostMapping("/")
    public ResponseEntity<PartyInteraction> createPartyInteraction(@RequestParam(required = false) String salesChannel,
                                                                   @RequestBody(required = true) PartyInteraction partyInteraction) throws Exception{
        partyInteraction.setId("200");
//        if (partyInteraction != null)
//            throw new Error("gayan","gayan","gayan");
//        return ResponseEntity.status(401).body(new PartyInteraction());
        return ResponseEntity.status(HttpStatus.CREATED).body(partyInteraction);

    }

    @PatchMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartyInteraction> updatePartyInteraction(@RequestParam(required = false) String salesChannel,
                                                                   @PathVariable(required = true) String id,
                                                                   @RequestBody(required = true) List<PatchElement> patchElement){
        System.out.println("open api reached");
        PartyInteraction partyInteraction = new PartyInteraction();
        partyInteraction.setId("1545871");
        Channel channel = new Channel();
        channel.setId("channel id");
        partyInteraction.setChannel(Arrays.asList(channel));
        partyInteraction.setDescription("description");
        Map<String,String> map = new HashMap<>();
        map.put("title","No Signal Issue");
        map.put("msisdn","0715973494");
        map.put("otherChannelId","string");
        partyInteraction.setExtensions(map);
        ControlFields controlFields = new ControlFields();
        controlFields.setCreatedBy("created by");
        controlFields.setCreatedOn("created on");
        partyInteraction.setControlFields(controlFields);
        TimePeriod timePeriod = new TimePeriod();
        timePeriod.setEndDateTime("end date");
        timePeriod.setStartDateTime("start date");
        partyInteraction.setInteractionDate(timePeriod);
        InteractionItem interactionItem = new InteractionItem();
        Map<String,String> interactionItemMap = new HashMap<>();
        interactionItemMap.put("subReason","subReason");
        interactionItem.setExtensions(interactionItemMap);
        List<Note> notes = new ArrayList<>();
        Note note = new Note();
        note.setText("this is the patch note");
        notes.add(note);
        interactionItem.setNote(notes);
        interactionItem.setItemDate(timePeriod);
        EntityRef entityRef = new EntityRef();
        entityRef.setReferedtype("Case");
        entityRef.setId("entity id");
        interactionItem.setItem(entityRef);
        partyInteraction.setInteractionItem(Arrays.asList(interactionItem));

        partyInteraction.setRelatedParty(Arrays.asList(new RelatedPartyRef()));

        return ResponseEntity.status(HttpStatus.OK).body(partyInteraction);
//        return ResponseEntity.status(401).body(new PartyInteraction());
    }

    @PostMapping("/suspend")
    public ResponseEntity<ProductOrderRef> suspendSubscriber(@RequestBody(required = true) SuspendOrder suspendOrder){
        System.out.println("reached");
        ProductOrderRef productOrderRef = new ProductOrderRef();
        productOrderRef.setId("ProductOrder_17392091");

        SuspendResumeError error = new SuspendResumeError();
        error.setReason("");

        return ResponseEntity.status(HttpStatus.OK).body(productOrderRef);
    }

    @PostMapping("/resume")
    public ResponseEntity<String> resumeSubscriber(@RequestBody(required = true) ResumeOrder suspendOrder){
        return ResponseEntity.status(HttpStatus.OK).body("Resume Success");
    }

//    @PostMapping("/oppurchase")
//    public ResponseEntity<String> addAOPP(@RequestParam(required = true) String serviceid,
//                                          @RequestParam(required = false) String qid,
//                                          @RequestParam(required = false) String username,
//                                          @RequestParam(required = false) String channel,
//                                          @RequestParam(required = true) String MISIDN){
//        System.out.println(serviceid +":"+ username + channel +":"+ MISIDN);
//        return ResponseEntity.status(HttpStatus.OK).body("ADD AO/PP Success");
//    }

    @PostMapping("/oppurchase")
    public ResponseEntity<String> addAOPP(@RequestParam String serviceid,
                                          @RequestParam(required = false) String username,
                                          @RequestParam(required = false) String qid,
                                          @RequestParam(required = false) String channel,
                                          @RequestParam String MSISDN){
        System.out.println(serviceid);
        System.out.println(username);
        System.out.println(qid);
        System.out.println(channel);
        System.out.println(MSISDN);
        return ResponseEntity.status(HttpStatus.OK).body("ADD AO/PP Success");
    }

    @GetMapping("/oppurchase")
    public ResponseEntity<String> getAOPP(@RequestParam String serviceid,
                                          @RequestParam(required = false) String qid,
                                          @RequestParam(required = false) String username,
                                          @RequestParam(required = false) String channel,
                                          @RequestParam(required = false) String MISIDN){
        System.out.println(serviceid +":"+ username + channel +":"+ MISIDN);
        return ResponseEntity.status(HttpStatus.OK).body("ADD AO/PP Success");
    }

//    @PostMapping("/unittesting")
//    public ResponseEntity<String> unitTesting(@RequestBody String str){
//        ResponseEntity<String> response = testService.testMethod(str);
//        return response;
//    }



    @GetMapping("/newtest")
    public ResponseEntity<String> getTestMethod(){
        return ResponseEntity.status(HttpStatus.OK).body("test passed");
    }

//    @PostMapping("/jwt-token")
//    public ResponseEntity<String> getJWTToken(@RequestBody JWTToken token) throws InterruptedException {
//        if (token.getOp().equalsIgnoreCase("update"))
//            return testService.updateToken(token);
//        if (token.getOp().equalsIgnoreCase("get"))
//            return testService.getNewToken(token);
//        if (token.getOp().equalsIgnoreCase("save"))
//            return testService.saveToken(token);
//        if (token.getOp().equalsIgnoreCase("withoutExp"))
//            return testService.saveWithoutExp(token);
//        return testService.getToken(token);
//    }

    @PostMapping("/jwt-token-new")
    public ResponseEntity<String> getJWTTokenNew(@RequestBody JWTToken token) throws InterruptedException, ExecutionException {
        if (token.getOp().equalsIgnoreCase("save"))
            return testService.saveTokenNew(token);
        if (token.getOp().equalsIgnoreCase("get"))
            return testService.getNewTokenNew(token);
        if (token.getOp().equalsIgnoreCase("exist"))
            return testService.exists(token);
        return testService.saveWithoutExpNew(token);
    }

    @PostMapping("/jwt-token-get-all")
    public ResponseEntity<CommonAdaptorResp<List<String>>> getJWTTokenAllNew(@RequestBody JWTToken token, HttpServletRequest httpServletRequest) throws Exception {
        return testService.getAllEntries(token);
    }

    @GetMapping("/get-list")
    public ResponseEntity<List<String>> getUnitTesting() throws ExecutionException, InterruptedException {
        return testService.testMethod();
    }

//    @GetMapping("get-role/{roleId}")
//    public ResponseEntity<Role>

    public int addition(int a, int b){
        return testService.add(a,b);
    }
}
