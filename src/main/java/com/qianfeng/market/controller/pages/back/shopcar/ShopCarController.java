package com.qianfeng.market.controller.pages.back.shopcar;

import com.qianfeng.market.controller.BaseController;
import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.Goods;
import com.qianfeng.market.pojo.entity.ShopCar;
import com.qianfeng.market.pojo.vo.ShopCarVO;
import com.qianfeng.market.service.GoodsService;
import com.qianfeng.market.service.ShopCarService;
import com.qianfeng.market.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * creator：Administrator
 * date:2019/12/17
 */
@Controller
@RequestMapping("/pages/back/shopCar")
public class ShopCarController extends BaseController {

    Logger logger = LoggerFactory.getLogger(ShopCarController.class);

    @Resource
    ShopCarService shopCarService;


    /**
     * 真正添加商品的方法
     *
     * @return
     */
    @RequestMapping("edit")
    @ResponseBody
    ResponseDTO edit(ShopCar shopCar, HttpSession session) {


        if (StringUtils.isEmpty(session.getAttribute("userId"))) {
            // 未授权
            return ResponseDTO.fail("操作失败，请登录", null, 401, 401);
        }
        shopCar.setUserId((Integer) session.getAttribute("userId"));


        return shopCarService.edit(shopCar);
    }

    /**
     * 真正添加商品的方法
     *
     * @return
     */
    @RequestMapping("shwoMyCar")
    String shwoMyCar(Model model) {
        if (!StringUtils.isEmpty(getUserId())) {
            List<ShopCarVO> cars = shopCarService.findUserCars(getUserId());
            model.addAttribute("cars", cars);
        } else {
            return "pages/front/login/loginPage";
        }
        return "pages/back/shopcar/car-list";
    }


}
