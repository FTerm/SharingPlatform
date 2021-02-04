package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.bo.mode.ModeAddBO;
import com.ckhun.goods.bo.mode.ModeDeleteBO;
import com.ckhun.goods.bo.mode.ModeUpdateBO;
import com.ckhun.goods.mapper.ModeMapper;
import com.ckhun.goods.pojo.GoodsMode;
import com.ckhun.goods.pojo.Mode;
import com.ckhun.goods.service.ModeService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import com.ckhun.utils.TrueOrFalseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@RestController
@RequestMapping("modeApi")
public class ModeServiceImpl extends ServiceImpl<ModeMapper, Mode> implements ModeService {

    @Autowired
    private GoodsModeServiceImpl goodsModeService;

    @Override
    public R<Boolean> addMode(@RequestBody ModeAddBO modeAddBO) {
        AssertException.isNotBlank(modeAddBO.getModeName(), ErrorEnum.VALIDATION_EOR.getErrCode(),"模式名不能为空");
        AssertException.isNotBlank(modeAddBO.getDescription(), ErrorEnum.VALIDATION_EOR.getErrCode(),"模式描述不能为空");
        AssertException.isNotNull(modeAddBO.getStatus(), ErrorEnum.VALIDATION_EOR.getErrCode(),"模式状态不能为空");

        Mode mode = new Mode();
        mode.setDelFlag(TrueOrFalseEnum.TRUE_STAUTS.getStatus());
        mode.setModeName(modeAddBO.getModeName());
        mode.setDescription(modeAddBO.getDescription());
        mode.setStatus(modeAddBO.getStatus());
        mode.setCreateTime(TimeUtil.getCreateTime());
        mode.setUpdateTime(TimeUtil.getCreateTime());

        boolean save = this.save(mode);
        AssertException.isTrue(save,ErrorEnum.FAIL.getErrCode(),"新增失败");

        R<Boolean> booleanR = new R<>();
        booleanR.setData(Boolean.TRUE);
        return booleanR;
    }

    @Override
    public R<Boolean> remove(@RequestBody ModeDeleteBO modeDeleteBO) {
        AssertException.isNotNull(modeDeleteBO.getId(),ErrorEnum.VALIDATION_EOR.getErrCode(),"id为空");

        //是否还有引用该模式的商品
        List<GoodsMode> goodsMode = goodsModeService.list(new QueryWrapper<GoodsMode>().eq("mode_id", modeDeleteBO.getId()));
        AssertException.isTrue(goodsMode.size()<=0,ErrorEnum.FAIL.getErrCode(),"存在商品引用该模式");

        boolean b = this.removeById(modeDeleteBO.getId());
        AssertException.isTrue(b,ErrorEnum.FAIL.getErrCode(),"删除失败");

        R<Boolean> booleanR = new R<>();
        booleanR.setData(b);
        return booleanR;
    }

    @Override
    @Transactional
    public R<Boolean> updateMode(@RequestBody ModeUpdateBO modeUpdateBO) {
        AssertException.isNotNull(modeUpdateBO.getId(),ErrorEnum.VALIDATION_EOR.getErrCode(),"id为空");
        R<Boolean> r = new R<>();

        Mode mode = new Mode();
        BeanUtils.copyProperties(modeUpdateBO,mode);

        boolean b = this.updateById(mode);
        AssertException.isTrue(b,ErrorEnum.FAIL.getErrCode(),"更新失败");

        r.setData(b);

        return r;
    }

    @Override
    public R<Mode> getModeById(@RequestParam("id") Integer id) {
        AssertException.isNotNull(id,ErrorEnum.VALIDATION_EOR.getErrCode(),"id为空");
        Mode byId = this.getById(id);
        AssertException.isNotNull(byId,ErrorEnum.FAIL.getErrCode(),"模式不存在");

        R<Mode> r = new R<>();
        r.setData(byId);

        return r;
    }

    @Override
    public R<List<Mode>> listMode() {
        R<List<Mode>> listR = new R<>();
        listR.setData(this.list());
        return listR;
    }
}
