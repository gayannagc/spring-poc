package com.example.comettestproject.service;

import com.example.comettestproject.client.TestClient1;
import com.example.comettestproject.client.TestClient2;
import com.example.comettestproject.client.TestClient3;
import com.example.comettestproject.dto.*;
import com.example.comettestproject.dto.smssurvey.*;
import com.example.comettestproject.dto.tokenDto.JWTToken;
import com.example.comettestproject.mapper.Mapper;
import com.example.comettestproject.repository.CacheRepo2;
import com.example.comettestproject.util.constants.Constants;
import com.example.comettestproject.util.exception.BaseException;
import com.example.comettestproject.util.resultenum.ResponseCodeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.apache.xerces.internal.parsers.XMLDocumentParser;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

@Service
public class TestService {

    @Autowired
    CacheRepo2 cacheRepo2;
    @Autowired
    TestClient1 testClient1;
    @Autowired
    TestClient2 testClient2;
    @Autowired
    TestClient3 testClient3;
    @Autowired
    Mapper Map;


    public int add(int a, int b) {
        return a+b;
    }

//    public ResponseEntity<String> getToken(JWTToken token) {
//        UserCacheObject user = new UserCacheObject();
//        user.setUniqueId(token.getUniqueId());
//        user.setIdleTimeRange(System.currentTimeMillis());
//        cacheRepository.save(token.getUserName(),user);
//        return ResponseEntity.status(200).body(cacheRepository.findByUserName(token.getUserName()).getUniqueId());
//    }
//
//    public ResponseEntity<String> updateToken(JWTToken token) throws InterruptedException {
//        UserCacheObject user1 = new UserCacheObject();
//        user1.setUniqueId(token.getUniqueId());
//        user1.setIdleTimeRange(System.currentTimeMillis());
//        UserCacheObject user2 = new UserCacheObject();
//        user2.setUniqueId(token.getUniqueId());
//        user2.setIdleTimeRange(System.currentTimeMillis());
//        cacheRepository.save("gayannagc",user2);
//        cacheRepository.save(token.getUserName(),user1);
//        UserCacheObject userCacheObject1 = cacheRepository.findByUserName("gayannagc");
//        UserCacheObject userCacheObject2 = cacheRepository.findByUserName(token.getUserName());
//        return ResponseEntity.status(200).body(String.valueOf(cacheRepository.findByUserName("gayannagc").getIdleTimeRange() - cacheRepository.findByUserName(token.getUserName()).getIdleTimeRange()));
//    }
//
//    public ResponseEntity<String> getNewToken(JWTToken token){
//        UserCacheObject userCacheObject = cacheRepository.findByUserName(token.getUserName());
//        return ResponseEntity.status(200).body(userCacheObject.getUniqueId());
//
//    }
//
//    public ResponseEntity<String> saveToken(JWTToken token) {
//        UserCacheObject user1 = new UserCacheObject();
//        user1.setUniqueId(token.getUniqueId());
//        user1.setIdleTimeRange(System.currentTimeMillis());
//        cacheRepository.save(token.getUserName(),user1);
//        UserCacheObject userCacheObject1 = cacheRepository.findByUserName(token.getUserName());
//        return ResponseEntity.status(200).body(userCacheObject1.getUniqueId());
//    }
//
//    public ResponseEntity<String> saveWithoutExp(JWTToken token) {
//        UserCacheObject user1 = new UserCacheObject();
//        user1.setUniqueId(token.getUniqueId());
//        user1.setIdleTimeRange(System.currentTimeMillis());
//        cacheRepository.saveWithoutExp(token.getUserName(),user1);
//        UserCacheObject userCacheObject1 = cacheRepository.findByUserName(token.getUserName());
//        return ResponseEntity.status(200).body(userCacheObject1.getUniqueId());
//    }

    public ResponseEntity<String> saveTokenNew(JWTToken token) {
        cacheRepo2.save(token.getUserName(), token.getUniqueId());
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    public ResponseEntity<String> saveWithoutExpNew(JWTToken token){
        cacheRepo2.saveWithoutExp(token.getUserName(), token.getUniqueId());
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    public ResponseEntity<String> getNewTokenNew(JWTToken token){
        String username = cacheRepo2.getByUserName(token.getUserName());
        return ResponseEntity.status(HttpStatus.OK).body(username);
    }

    public ResponseEntity<List<String>> testMethod() throws ExecutionException, InterruptedException {
//        return CompletableFuture.supplyAsync(() -> {
//            ExecutorService executor = Executors.newFixedThreadPool(4);
//
//            List<String> numberList = Arrays.asList("1", "2", "3", "4","5");
//
//            List<CompletableFuture<String>> completableFutureList = new ArrayList<>();
//            for(String number : numberList){
//                CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> apiCall01(number));
//                CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> apiCall02(number));
//                CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> apiCall03(number));
//                CompletableFuture<Void> future = CompletableFuture.allOf(future1,future2,future3);
//
//                CompletableFuture<String> completableFutureResult = CompletableFuture.supplyAsync(() -> {
//                    future.thenApply(ignoredVoidResult -> {
//                        try {
//                            String mappedResult = mapper(future1.get(),future2.get(),future3.get());
//                            return mappedResult;
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        } catch (ExecutionException e) {
//                            e.printStackTrace();
//                        }
//
//                        return null;
//                    }).thenApply(result -> r);
//                    return null;
//                });
//
//                completableFutureList.add(completableFutureResult);
//            }
//
//
//            List<String> lisOfString = new ArrayList<>();
//            numberList.stream()
//                    .map(number ->
//                            Arrays.asList(CompletableFuture.supplyAsync(() -> apiCall01(number)),CompletableFuture.supplyAsync(() -> apiCall02(number)),CompletableFuture.supplyAsync(() -> apiCall03(number))))
//                    .map(result -> CompletableFuture.allOf(result.toArray(new CompletableFuture[result.size()]))
//                            .thenApply(v -> result.stream().map(future -> future.join()).collect(Collectors.toList())))
//                    .map(finalResult -> finalResult
//                            .thenApply(completedResult -> mapper(completedResult.get(0),completedResult.get(1),completedResult.get(2)))
//                            .thenApply(fr -> lisOfString.add(fr)));
//
//            return ResponseEntity.status(HttpStatus.OK).body(lisOfString);
//        }).get();


//        numberList
//                .stream().map(number -> CompletableFuture.supplyAsync(() -> apiCall01(number)).thenCombine(CompletableFuture.supplyAsync(()-> apiCall02(number)) ))


//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> apiCall03());

//        numberList.stream()
//                .map(number ->
//                        CompletableFuture.supplyAsync(() -> apiCall01(number))
//                                .thenCompose(result1-> CompletableFuture.supplyAsync(() -> apiCall02(number))
//                                        .thenCompose(result2 -> CompletableFuture.supplyAsync(() -> apiCall03(number)))))
//
//
//
//        List<String> topSites = Arrays.asList(
//                "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com"
//        );
//
//        List<CompletableFuture<Double>> relevanceFutures = topSites.stream().
//                map(site -> CompletableFuture.supplyAsync(() -> downloadSite(site), executor)).
//                map(contentFuture -> contentFuture.thenApply(this::parse)).
//                map(docFuture -> docFuture.thenCompose(this::calculateRelevance)).
//                collect(Collectors.<CompletableFuture<Double>>toList());

//
//        return ResponseEntity.status(HttpStatus.OK).body("test passed");
        return null;
    }

    private Document parse(String xml){return null;}
    private CompletableFuture<Double> calculateRelevance(Document doc){return null;}

    private String downloadSite(final String site) {
//        try {
//
//            final String res = IOUtils.toString(new URL("http://" + site), UTF_8);
//
//            return res;
//        } catch (IOException e) {
//            throw Throwables.propagate(e);
//        }
        return null;
    }

    @Async
    public CompletableFuture<String> apiCall01(String key){
//        System.out.println("api 01 called");
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "api-01-" + key +"-result";
        });
    }

    @Async
    public CompletableFuture<String> apiCall02(String key){
//        System.out.println("api 02 called");
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "api-02-" + key +"-result";
        });
    }

    @Async
    public CompletableFuture<String> apiCall03(String key){
//        System.out.println("api 03 called");
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "api-03-" + key +"-result";
        });
    }

    public String mapper(CompletableFuture<String> result1,CompletableFuture<String> result2,CompletableFuture<String> result3) throws BaseException {
//        System.out.println("mapper called");
        try {
            return result1.get() +"-"+result2.get()+"-"+ result3.get() +"-mapped";

        }catch (Exception e){
            throw new BaseException("mapper errror");
        }
    }
    XmlMapper xmlMapper = new XmlMapper();

    public ResponseEntity<String> smsProcessor(Interaction interaction, String cacheId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(xmlMapper.writeValueAsString(sumsSurvey(interaction)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.OK).body(ex.getMessage());
        }
    }

    public SmsSurveyEnv sumsSurvey(Interaction interaction) throws BaseException {
        try {
            SmsSurveyEnv smsSurveyEnv = new SmsSurveyEnv("http://schemas.xmlsoap.org/soap/envelope/","http://schemas.xl.co.id/cle/namespace/Public/Common/RequestHeader.xsd","http://schemas.xl.co.id/common/CommonResponse/V1.0","http://schemas.xl.co.id/esb/payloads/Bil/SMSSurvey/V1.0");
            smsSurveyEnv.setXmlHeader(headerCreator());
            smsSurveyEnv.setSmsSurveyBody(bodyCreator(interaction));
            return smsSurveyEnv;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(), HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(),ex.getStackTrace());
        }
    }

    private SmsSurveyBody bodyCreator(Interaction interaction) throws BaseException {
        try {
            SmsSurveyBody smsSurveyBody = new SmsSurveyBody();
            smsSurveyBody.setSmsSurveyHeader(bodyHeaderCreator());
            smsSurveyBody.setSmsSurveyRq(surveyReqCreator(interaction));
            return smsSurveyBody;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(), HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(),ex.getStackTrace());

        }
    }

    private SmsSurveyRq surveyReqCreator(Interaction interaction) throws BaseException {
        try {
            SmsSurveyRq smsSurveyRq = new SmsSurveyRq();
            smsSurveyRq.setMsisdn(interaction.getMsisdn());
            Calendar c= Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date now = new Date();
            smsSurveyRq.setTimeStamp(sdf.format(now));
            smsSurveyRq.setReason1(interaction.getInteractionItems().iterator().next().getReason1());
            smsSurveyRq.setReason2(interaction.getInteractionItems().iterator().next().getReason2());
            smsSurveyRq.setReason3(interaction.getInteractionItems().iterator().next().getReason3());
            //set supervisor
            //set work group
            smsSurveyRq.setCreatedBy(interaction.getCreatedBy());
            smsSurveyRq.setFullName(interaction.getCreatedBy());
            smsSurveyRq.setDirection(interaction.getDirection().toString());
            Map<String,String> nameValuePair = new HashMap<>();
            nameValuePair.put(Constants.V11 + Constants.NAME,Constants.TYPE);
            nameValuePair.put(Constants.V11 + Constants.VALUE,interaction.getType().toString());
            smsSurveyRq.setNameValuePairs(Arrays.asList(nameValuePair));
            return smsSurveyRq;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(), HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(),ex.getStackTrace());
        }
    }

    private SmsSurveyHeader bodyHeaderCreator() throws BaseException {
        try {
            SmsSurveyHeader smsSurveyHeader = new SmsSurveyHeader("svcBilSMSSurveyV1.0","JMSInstance01.XL.BIL.SMSSURVEY.V1_0.REQ");
            return smsSurveyHeader;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(), HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(),ex.getStackTrace());

        }
    }

    private SmsSurveySoapHeader headerCreator() throws BaseException {
        try {
            SmsSurveySoapHeader smsSurveySoapHeader = new SmsSurveySoapHeader();
            return smsSurveySoapHeader;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage(), ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(), HttpStatus.INTERNAL_SERVER_ERROR,ResponseCodeEnum.EXCEPTION_MAPPER_LAYER.description(),ex.getStackTrace());
        }
    }





    public ResponseEntity<CommonAdaptorResp<List<String>>> getAllEntries(JWTToken token) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        Long t2 = System.currentTimeMillis();
        List<String> numberList = Arrays.asList("1");
        System.out.println(numberList.size());
        List<CompletableFuture<CompletableFuture<String>>> listOfResults = new ArrayList<>();
        System.out.println("main method: " + Thread.currentThread().getName());
        for (String number : numberList){
            CompletableFuture<CompletableFuture<String>> loopResult = CompletableFuture.supplyAsync(() -> {
                CompletableFuture<String> call01 = null;
                CompletableFuture<String> call02 = null;
                CompletableFuture<String> call03 = null;

                try {
                    call01 =  testClient1.apiCall01(number,executorService);
                } catch (BaseException e) {
                    call01 = CompletableFuture.completedFuture(e.getMessage());
                }

                try {
                    call02 =  testClient2.apiCall02(number,executorService);
                } catch (BaseException e) {
                    call02 =  CompletableFuture.completedFuture(e.getMessage());
                }

                try {
                    call03 =  testClient3.apiCall03(number,executorService);
                } catch (BaseException e) {
                    call03 = CompletableFuture.completedFuture(e.getMessage());
                }

                CompletableFuture<String> finalCall0 = call01;
                CompletableFuture<String> finalCall01 = call02;
                CompletableFuture<String> finalCall02 = call03;
                CompletableFuture<String> result =  CompletableFuture.allOf(finalCall0,finalCall01,finalCall02).thenApplyAsync(ignoredVoid -> {
                    String mappedString = new String();
                    try {
                        mappedString =  Map.mapper(finalCall0, finalCall01, finalCall02);
                    } catch (BaseException e) {
                        mappedString = "error-map-async";
                    }
                    return mappedString;
                },executorService);
                return result;
            },executorService);
            listOfResults.add(loopResult);
        }

        CompletableFuture<List<CompletableFuture<String>>> futureOfListNew = CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[0])).thenApply(v ->  listOfResults.stream().map(CompletableFuture::join).collect(toList()));
        List<CompletableFuture<String>> extractedFutures = futureOfListNew.get();
        CompletableFuture<List<String>> finalResult = CompletableFuture.allOf(extractedFutures.toArray(new CompletableFuture[0])).thenApply(v -> extractedFutures.stream().map(CompletableFuture::join).collect(toList()));

        List<String> finalResults = finalResult.get();
        Result result = new Result();
        result.setResultCode("00");
        result.setResultDescription("description");
        CommonAdaptorResp<List<String>> resp = new CommonAdaptorResp<>();
        resp.setResult(result);
        resp.setResponseData(finalResults);

        System.out.println("thread time " + (System.currentTimeMillis() - t2));
        return ResponseEntity.status(HttpStatus.OK).body(resp);


    }


    private CompletableFuture<String> stringSupplier(String str,Long count){
        return CompletableFuture.supplyAsync(() -> {
            try {
//                if (str.equalsIgnoreCase("two"))
//                    throw new Exception("my exception");
                Long time1 = System.currentTimeMillis();
                Thread.sleep(count);
                Long time2 = System.currentTimeMillis();
                Long timeDif = time2 - time1;
                System.out.println("stringSupplier " + timeDif);
                return " supplied string - " + str +" ";

            }catch (Exception e){
                throw new CompletionException(e);
            }
        });
    }

    public ResponseEntity<String> exists(JWTToken token) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        return ResponseEntity.status(HttpStatus.OK).body(completableFuture.get());
    }
    ObjectMapper om = new ObjectMapper();
    XmlMapper mapper = new XmlMapper();

    public ResponseEntity<String> getXml() throws IOException, XMLStreamException, JAXBException {

        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.FALSE);
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/main/resources/input.xml"));
        Reader reader = new StringReader("");
        XMLStreamReader xsrNew = xif.createXMLStreamReader(reader);

        XMLDocumentParser xmlDocumentParser =  new XMLDocumentParser();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(DeserializationFeature.NA, Boolean.FALSE);

        xsr.nextTag(); // Advance to Envelope tag
        String localName1 = xsr.getLocalName();
        xsr.nextTag(); // Advance to Body tag
        String localName2 = xsr.getLocalName();
        xsr.nextTag(); // Advance to LoginResponse tag
//        xsr.nextTag(); // Advance to LoginResult tag


        SoapResponseHeader soapResponseHeader =  mapper.readValue(xsr,SoapResponseHeader.class);


//        JAXBContext jc = JAXBContext.newInstance(SoapResponseHeader.class);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        JAXBElement<SoapResponseHeader> je = unmarshaller.unmarshal(xsr, SoapResponseHeader.class);
//        SoapResponseHeader soapResponseHeader = je.getValue();
//        LoginResult loginResult = je.getValue();

//        System.out.println(je.getName());
//        System.out.println(je.getValue());
//        System.out.println(loginResult.getErrorMessage());

        SampleXmlObject sampleXmlObject = new SampleXmlObject();
        sampleXmlObject.setStringField("string");
        sampleXmlObject.setStringField("integer");
        Map<String,String> innerMap = new HashMap<>();
        innerMap.put("v11:name","name");
        innerMap.put("V11:value","value");
        sampleXmlObject.setListField(Arrays.asList(innerMap,innerMap));
        sampleXmlObject.setTimestampField(new Timestamp(new Date().getTime()));
        SoapBody soapBody = new SoapBody();
        XmlHeader xmlHeader = new XmlHeader();
        soapBody.setXmlHeader(xmlHeader);
        soapBody.setSampleXmlObject(sampleXmlObject);
        SoapRequest soapRequest = new SoapRequest();
        soapRequest.setSoapBody(soapBody);
        String str = mapper.writeValueAsString(soapRequest);
        String prefix = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:req=\"http://schemas.xl.co.id/cle/namespace/Public/Common/RequestHeader.xsd\" xmlns:v1=\"http://schemas.xl.co.id/common/CommonResponse/V1.0\" xmlns:v11=\"http://schemas.xl.co.id/esb/payloads/Bil/SMSSurvey/V1.0\">\n";
        String postFix = "</soapenv:Envelope>";
        return ResponseEntity.status(200).body(str);
    }
}

//    @Async
//    public CompletableFuture<CompletableFuture<String>> loopProcessor(String number,ExecutorService executorService){
//        return CompletableFuture.supplyAsync(() -> {
//            CompletableFuture<String> call01 = testClient1.apiCall01(number,executorService);
//            CompletableFuture<String> call02 = testClient2.apiCall02(number,executorService);
//            CompletableFuture<String> call03 = testClient3.apiCall03(number,executorService);
//            CompletableFuture<String> result =  CompletableFuture.allOf(call01,call02,call03).thenApplyAsync(ignoredVoid -> mapper(call01,call02,call03),executorService);
//            return result;
//        });
//    }

//        List<String> numberList = Arrays.asList("1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4","1","2","3","4");



//        CompletableFuture<String> call01d = apiCall01("1");
//        CompletableFuture<String> call02d = apiCall02("1");
//        CompletableFuture<String> call03d = apiCall03("1");
//
//        CompletableFuture<String> strResult = CompletableFuture.allOf(call01d,call02d,call03d).thenApply(voidR -> mapper(call01d,call02d,call03d));
//        String realResult = strResult.get();
//, "2", "3", "4","5"


//        for (String number : numberList){
//            CompletableFuture<CompletableFuture<String>> loopResult = loopProcessor(number,executorService);
//            listOfResults.add(loopResult);
//        }


//            CompletableFuture<CompletableFuture<String>> loopResult = CompletableFuture.supplyAsync(() -> {
//                CompletableFuture<String> call01 = apiCall01(number);
//                CompletableFuture<String> call02 = apiCall02(number);
//                CompletableFuture<String> call03 = apiCall03(number);
//                CompletableFuture<String> result =  CompletableFuture.allOf(call01,call02,call03).thenApplyAsync(ignoredVoid -> mapper(call01,call02,call03),executorService);
//                return result;
//            },executorService);


//        List<CompletableFuture<String>> newListOfResults = futureOfList1.get();
//        CompletableFuture<List<CompletableFuture<String>>> futureOfList = CompletableFuture.allOf(newListOfResults.toArray(new CompletableFuture[0])).thenApply(v ->  newListOfResults.stream().map(CompletableFuture::join).collect(toList()));


//        List<String> finalResp = new ArrayList<>();
//        CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[0])).join();
//        List<String> newResp = listOfResults.stream().map()
//        CompletableFuture<List<String>> finalRsp = CompletableFuture.supplyAsync(() -> {
//            response.get(false).stream().map(result -> {
//                try {
//                    return result.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }).collect(toList());
//            return null;
//        });

//        Map<Boolean, List<CompletableFuture<String>>> response = listOfResults.stream().collect(Collectors.partitioningBy(CompletableFuture::isCompletedExceptionally));
//        Map<Boolean,CompletableFuture<List<String>>> futureOfList2 = CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[0])).thenApply(v ->  listOfResults.stream().map(CompletableFuture::join).collect(Collectors.partitioningBy(CompletableFuture::isCompletedExceptionally)));



//        CompletableFuture<List<String>> futureOfList = CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[0])).thenApply(v ->  listOfResults1.stream().map(CompletableFuture::join).collect(toList()));
//        CompletableFuture<List<String>> futureOfList1 = CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[0])).thenApply(v ->  listOfResults.stream().map(CompletableFuture::join).collect(toList()));

//        List<CompletableFuture<CompletableFuture<String>>> -> CompletableFuture<List<Com
//        CompletableFuture.allOf(listOfResults.toArray(new CompletableFuture[]))

//        Long t3 = System.currentTimeMillis();
//        finalRsp.join();
//        Thread.sleep(10000);
//                .thenApply(voidResult -> {
//            Map<Boolean, List<CompletableFuture<String>>> response = listOfResults.stream().collect(Collectors.partitioningBy(CompletableFuture::isCompletedExceptionally));
//            finalResp = response.get(false).stream().map(result -> {
//                try {
//                    return result.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }).collect(Collectors.toList());
//            return ResponseEntity.;
//        });

//        List<String> newFinal = finalRsp.get();
//        System.out.println("time to execute the loop " + (t2-t1));
//        System.out.println("time to get the results  " + (t3-t2));


//        System.out.println("time to return the result " + (System.currentTimeMillis() - t3));


//        return ;

//        CompletableFuture<String> completableFuture1 = stringSupplier("one",200L);
//        CompletableFuture<String> completableFuture2 = stringSupplier("two",100L);
//        CompletableFuture<String> completableFuture3 = stringSupplier("three",300L);
//        CompletableFuture<Void> future = CompletableFuture.allOf(completableFuture1,completableFuture2,completableFuture3);

//        CompletableFuture<String> result = future.whenComplete((result1,result2,result3,ex) -> {
//           return result1+result2+result3;
//        })

//        CompletableFuture<String> result =completableFuture1
//                .thenCombineAsync(completableFuture2,(f1,f2) -> f1+f2,executorService)
//                .thenCombineAsync(completableFuture3,(f2,f3) -> f2+f3,executorService);

//        try {
//            CompletableFuture<String> result = new CompletableFuture<>();
//            List<String> resultList = new ArrayList<>();
//            int[] numbers = {1,2,3,4,5};
//            List<CompletableFuture<String>> streamResult= new ArrayList<>();
//            List<CompletableFuture<Void>> futureList = new ArrayList<>();
//
//            Arrays.stream(numbers).forEach(number -> {
//                CompletableFuture.supplyAsync(() -> {
//                    return completableFuture1
//                            .thenCompose(value1 -> completableFuture2
//                                    .thenCompose(value2 -> completableFuture3
//                                            .thenApply(value3-> value3+value2+value1)))
//                            .exceptionally(ex -> {
//                                throw (RuntimeException)ex;
//                            });
//                }).thenApply(fResult -> streamResult.add(fResult));
//            });
//
//            CompletableFuture.allOf(streamResult.toArray(new CompletableFuture[0])).join();
//            List<String> response = streamResult.stream().map(str -> {
//                try {
//                    return str.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }).collect(Collectors.toList());

//            for (int i = 0; i < 5; i++) {
//                completableFuture1
//                        .thenCompose(value1 -> completableFuture2
//                                .thenCompose(value2 -> completableFuture3
//                                        .thenApply(value3-> value3+value2+value1)))
//                        .exceptionally(ex -> {
//                            throw (RuntimeException)ex;
//                        }).thenAccept(value-> Collectors.toList());
//            }


//            Long time2 = System.currentTimeMillis();
//            Long timeDif = time2 - time1;
//            System.out.println("function " + timeDif);
////            result.join();
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//
//        }catch (RuntimeException e){
//            List<String> list = new ArrayList<>();
//            list.add("error");
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }


//        CompletableFuture<String> result = completableFuture1
//                .thenCompose(value1 -> (completableFuture2.thenApply(value -> value +" " + value1)))
//                .thenCompose(value2 -> (completableFuture3.thenApply(value -> value+" " + value2)));

//        CompletableFuture.allOf(completableFuture1,completableFuture2,completableFuture3).join();
//
//        List<String> stringList = new ArrayList<>();
//        stringList.add(completableFuture1.get());
//        stringList.add(completableFuture2.get());
//        stringList.add(completableFuture3.get());
//        return ResponseEntity.status(HttpStatus.OK).body(stringList);

//        completableFuture1.thenCompose(value -> completableFuture2);

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

//
//        String combined = Stream.of(completableFuture1, completableFuture2, completableFuture3)
//                .map(CompletableFuture::join)
//                .collect(Collectors.joining(" "));

//        future.thenApply(value ->)



//        return ResponseEntity.status(HttpStatus.OK).body(completableFuture1
//                .thenCompose(value1 -> (completableFuture2.thenApply(value -> value +" " + value1)))
//                .thenCompose(value2 -> (completableFuture3.thenApply(value -> value+" " + value2))).get()
//        );