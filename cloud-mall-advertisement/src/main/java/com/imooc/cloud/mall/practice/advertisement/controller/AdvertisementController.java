package com.imooc.cloud.mall.practice.advertisement.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.advertisement.constant.AdvertisementConstant;
import com.imooc.cloud.mall.practice.advertisement.model.pojo.Advertisement;
import com.imooc.cloud.mall.practice.advertisement.model.request.AddAdvertisementReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.AdvertisementListReq;
import com.imooc.cloud.mall.practice.advertisement.model.request.UpdateAdvertisementReq;
import com.imooc.cloud.mall.practice.advertisement.service.AdvertisementService;
import com.imooc.cloud.mall.practice.common.common.ApiRestResponse;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallException;
import com.imooc.cloud.mall.practice.common.exception.ImoocMallExceptionEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * @description: 广告控制器
 * @author: Rex
 * @create: 2021-07-17 14:26
 */
@RestController
public class AdvertisementController {

  @Autowired
  private AdvertisementService advertisementService;

  @Value("${file.upload.ip}")
  private String ip;

  @Value("${file.upload.port}")
  private Integer port;

  /**
   * 广告列表（前台）
   * @param advertisementListReq 请求广告列表表单
   * @return 广告列表
   */
  @GetMapping("/advertisement/list")
  public ApiRestResponse<PageInfo<Advertisement>> list(AdvertisementListReq advertisementListReq){
    PageInfo<Advertisement> pageInfo = advertisementService.list(advertisementListReq);
    return ApiRestResponse.success(pageInfo);
  }

  /**
   * 广告详情（前台）
   * @param id 广告编号
   * @return 广告详情
   */
  @GetMapping("/advertisement/detail")
  public ApiRestResponse<Advertisement> detail(Integer id){
    return ApiRestResponse.success(advertisementService.detail(id));
  }


  /**
   * 根据URI获取主机地址和端口号信息，如：http://localhost:8085/
   * @param uri uri地址
   * @return 返回host地址
   */
  private URI getHost(URI uri){
    URI effectiveURI;
    try {
      effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), ip, port, null,null, null);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      effectiveURI = null;
    }
    return effectiveURI;
  }

  /**
   * 上传图片文件（后台）
   * @param httpServletRequest 请求
   * @param file 待上传的文件
   * @return 上传后的文件的地址
   */
  @ApiOperation("上传图片文件（后台）")
  @PostMapping("/admin/upload/file")
  public ApiRestResponse<String> upload(HttpServletRequest httpServletRequest, @RequestParam("file")MultipartFile file){
    // 获取上传的文件名
    String filename = file.getOriginalFilename();
    // 获取文件的后缀名
    String suffixName = filename.substring(filename.lastIndexOf("."));
    // 生成文件名UUID
    UUID uuid = UUID.randomUUID();
    String newFilename = uuid + suffixName;
    //创建文件夹和文件
    File fileDirectory = new File(AdvertisementConstant.FILE_UPLOAD_DIR);
    File destFile = new File(AdvertisementConstant.FILE_UPLOAD_DIR + newFilename);
    if (!fileDirectory.exists()){
      // 递归创建文件夹
      if(!fileDirectory.mkdirs()){
        throw new ImoocMallException(ImoocMallExceptionEnum.MKDIR_FAILED);
      }
    }
    try {
      // 将文件的数据流到目标文件中
      file.transferTo(destFile);
    } catch (IOException e) {
      e.printStackTrace();
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
    try {
      // 返回图片路径
      return ApiRestResponse.success(getHost(new URI(httpServletRequest.getRequestURL()+"")) + "/advertisement/images/" + newFilename);
    } catch (URISyntaxException e) {
      e.printStackTrace();
      throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
    }
  }

  /**
   * 新增广告（后台）
   * @param addAdvertisementReq 新增广告表单
   * @return 处理结果
   */
  @ApiOperation("新增广告（后台）")
  @PostMapping("/admin/advertisement/add")
  public ApiRestResponse<Void> add(@Validated @RequestBody AddAdvertisementReq addAdvertisementReq){
    advertisementService.add(addAdvertisementReq);
    return ApiRestResponse.success();
  }

  /**
   * 更新广告（后台）
   * @param updateAdvertisementReq 更新广告表单
   * @return 处理结果
   */
  @ApiOperation("更新广告（后台）")
  @PutMapping("/admin/advertisement/update")
  public ApiRestResponse<Void> update(@Validated @RequestBody UpdateAdvertisementReq updateAdvertisementReq){
    advertisementService.update(updateAdvertisementReq);
    return ApiRestResponse.success();
  }

  /**
   * 删除广告（后台）
   * @param id 广告编号
   * @return 处理结果
   */
  @ApiOperation("删除广告（后台）")
  @DeleteMapping("/admin/advertisement/delete")
  @ResponseBody
  public ApiRestResponse<Void> deleteCategory(@RequestParam Integer id){
    advertisementService.delete(id);
    return ApiRestResponse.success();
  }


  /**
   * 广告列表(后台）
   * @param advertisementListReq 广告请求列表表单
   * @return 广告列表
   */
  @ApiOperation("广告列表(后台）")
  @GetMapping("/admin/advertisement/list")
  public ApiRestResponse<PageInfo<Advertisement>> listForAdmin(AdvertisementListReq advertisementListReq){
    return ApiRestResponse.success(advertisementService.list(advertisementListReq));
  }
}
