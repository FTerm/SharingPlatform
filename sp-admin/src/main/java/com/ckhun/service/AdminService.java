package com.ckhun.service;

import com.ckhun.pojo.dto.AdminAddDTO;
import com.ckhun.pojo.dto.AdminLoginDTO;
import com.ckhun.pojo.vo.AdminProfileVo;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:33 2021/2/8
 * @description :
 * @since : 1.0.0
 */

public interface AdminService {

    R<?> insertAdmin(AdminAddDTO adminAddDTO);

    @Deprecated
    R<?> updateAdmin();

    R<?> loginAdmin(AdminLoginDTO adminLoginDTO);

    R<?> delAdmin(Integer id);

    PageResult selectAdminByPage(PageRequest pageRequest);

    R<AdminProfileVo> profileAdmin(AdminLoginDTO adminLoginDTO);


}
