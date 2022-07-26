package com.cq.wen.oneself.client.system.model;



/**
 * 文件服务
 * 
 * @author ruoyi
 */
//@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface RemoteFileService
{
    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public R<SysFile> upload(@RequestPart(value = "file") MultipartFile file);
}
