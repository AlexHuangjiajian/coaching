package com.alex.coaching.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/**
 * @Author: alex_huang
 * @Description:
 * @Date: Create in 17:24 2019/12/4
 */
public class FileUtil {

    /**
     *
     * @param aFileName  导出名称
     * @param aFilePath  源路径
     * @param request
     * @param response
     */
    public static void doExport(String aFileName, String aFilePath, HttpServletRequest request, HttpServletResponse response){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file = null;
        file = new File(aFilePath);
        try{
            request.setCharacterEncoding("UTF-8");
            String agent = request.getHeader("User-Agent").toUpperCase();
            if ((agent.indexOf("MSIE") > 0) || ((agent.indexOf("RV") != -1) && (agent.indexOf("FIREFOX") == -1)))
                aFileName = URLEncoder.encode(aFileName, "UTF-8");
            else {
                aFileName = new String(aFileName.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename=" + aFileName);
            response.setHeader("Content-Length", String.valueOf(file.length()));
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
                bos.write(buff, 0, bytesRead);
            System.out.println("success");
            bos.flush();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println("导出文件失败！");
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                file.delete();
            } catch (Exception e) {
//               LOGGER.error("导出文件关闭流出错！", e);
            }
        }
    }
}
