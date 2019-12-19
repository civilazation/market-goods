package com.qianfeng.market.controller.pages.front.goods;

import com.qianfeng.market.controller.BaseController;
import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.Goods;
import com.qianfeng.market.service.GoodsService;
import com.qianfeng.market.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * creator：Administrator
 * date:2019/12/17
 */
@Controller
@RequestMapping("/pages/front/goods")
public class GoodsControllerFront extends BaseController {

    Logger logger = LoggerFactory.getLogger(GoodsControllerFront.class);

    @Resource
    GoodsService goodsService;


    @RequestMapping("goodsDetail/{goodsId}")
    String goodsDetail(@PathVariable Integer goodsId, Model model) {
        model.addAttribute("goods", goodsService.getGoodsDetail(goodsId));
        return "pages/front/goods/goods-detail";
    }

}
