package mvoronin.lr3.new_test_rest_service.service;

import lombok.RequiredArgsConstructor;
import mvoronin.lr3.new_test_rest_service.model.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyModifyService {
    @Override
    public Response modify(Response response) {

        response.setUid("Что-то сломалось");
        return response;
    }
}
