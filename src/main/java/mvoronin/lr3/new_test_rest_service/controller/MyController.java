package mvoronin.lr3.new_test_rest_service.controller;

import lombok.extern.slf4j.Slf4j;
import mvoronin.lr3.new_test_rest_service.model.Request;
import mvoronin.lr3.new_test_rest_service.model.Response;
import mvoronin.lr3.new_test_rest_service.service.MyModifyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;

    public MyController(@Qualifier("ModifySystemTime") MyModifyService myModifyService) {
        this.myModifyService = myModifyService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {

        log.info("Входящий request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseAfterModify = myModifyService.modify(response);

        log.info("Исходящий response: {}", responseAfterModify);

        return new ResponseEntity<>(responseAfterModify, HttpStatus.OK);
    }
}
