import xbin.com.util.FastDFSClientUtils;

import java.io.File;
import java.io.InputStream;


public class FastDFSTest {
	
	/**
	 * 上传
	 */
	public static void upload() throws Exception {
		// id:	group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg
		// fastdfsBasePath = http://219.230.50.86
		// url:	http://219.230.50.86/group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg
    	String path = "/Volumes/HGST/图片/6.1.jpg";
		File file = new File(path);
		String fileId = FastDFSClientUtils.upload(file, path);
		System.out.println("本地文件：" + path + "，上传成功！ 文件ID为：" + fileId);
	}
	
	/**
	 * 下载
	 */
	public static void download() throws Exception {
		// id:	group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg
		// url:	http://219.230.50.86/group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg
		String fileId = "group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg";
		InputStream inputStream = FastDFSClientUtils.download("group1", fileId);
		System.out.println(inputStream.available());
		String path = System.getProperty("user.dir") + File.separatorChar + "receive" +  File.separatorChar + "001.jpg";
		System.out.println(path);
		//FileUtils.copyInputStreamToFile(inputStream,  new File(path));
	}

	/**
	 * 删除
	 */
	public static void delete() throws Exception {
		String fileId = "group1/M00/00/00/2-YyVlhp1UuAFNGyAAUWJLN5Vto815.jpg";
		int result = FastDFSClientUtils.delete("group1", fileId);
		System.out.println(result == 0 ? "删除成功" : "删除失败:" + result);
	}


	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	

		upload();
		//download();
		//Thread.sleep(10000);
		//download();
		//Thread.sleep(10000);
		//download();
		//delete();

	}

}
