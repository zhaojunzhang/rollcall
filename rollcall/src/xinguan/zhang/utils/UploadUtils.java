package xinguan.zhang.utils;

import java.util.UUID;

/**
 * �ļ��ϴ�������
 * @author samsung
 *
 */

public class UploadUtils {
	//����uuidΨһ�ļ�����hash�㷨���ɷ�ɢĿ¼
	public static String generateRandomDir(String uuidname){
		int hashcode=uuidname.hashCode();
		int d1=hashcode&0xf;
		int d2=(hashcode>>4)&0xf;
		return "/"+d1+"/"+d2;
		
	}
	//����ΨһUUID����
	public static String generateUUIDName(String fileName){
		String ext = fileName.substring(fileName.lastIndexOf("."));
		
		return UUID.randomUUID().toString()+ext;
		
	}
	//�и��ļ���֮ǰ  ·��
	public static String subFileName(String fileName){
		//c:\aa\bb\cc\1.jpg---�������һ��\
		int index = fileName.lastIndexOf("\\");
		if(index!=1){
			//�ҵ���
			return fileName.substring(index+1);
		}
		return fileName;
	}
	//У��ͼƬ  �ǲ���ͼƬ��ʽ----����MIME  ����
	public static boolean checkImgType(String contentType){
		if(contentType.startsWith("image/")){
			return true;
			
		}else{
			return false;
		}
	}

}
