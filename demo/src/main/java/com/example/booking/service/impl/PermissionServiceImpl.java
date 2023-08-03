package com.example.booking.service.impl;

import com.example.booking.mapper.PermissionMapper;
import com.example.booking.model.request.PermissionRequest;
import com.example.booking.model.response.BaseResponse;
import com.example.booking.model.response.PermissionResponse;
import com.example.booking.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper mapper;

    public BaseResponse createPermission(PermissionRequest request){
        try{

            List<PermissionResponse> checkDuplicateMenu = mapper.checkDuplicate(request);

            for(PermissionResponse item : checkDuplicateMenu){
                if(item != null){
                    return new BaseResponse(item, "1", "Permission menu has been duplicate");
                }
            }

            int result = mapper.create(request);

            if(result > 0){
                return new BaseResponse("0", "Create successfully");
            }else {
                return new BaseResponse("1", "Create failure");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    public BaseResponse getPermission(PermissionRequest request){
        try{
            List<PermissionResponse> result = mapper.get(request);
            if(result.size() > 0){
                return new BaseResponse(result, "0", "success");
            }else {
                return new BaseResponse("1", "fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }
}
