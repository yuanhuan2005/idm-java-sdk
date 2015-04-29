package com.tcl.idm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * �ļ�������
 * 
 * @author yuanhuan
 * 2014��3��28�� ����3:14:29
 */
public class FileUtils
{
	/**
	 * ��ȡ�ļ�����
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @return �ļ�����
	 */
	public static String getFileFormat(String filePath)
	{
		String fileFormat = "";

		// �����ǿռ��
		if (null == filePath || "".equals(filePath))
		{
			return fileFormat;
		}

		// ����ļ��Ƿ�������
		if (filePath.indexOf(".") < 0)
		{
			return fileFormat;
		}

		fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);

		return fileFormat;
	}

	/**
	 * �ж��ļ��Ƿ����
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @return true��ʾ���ڣ�false��ʾ������
	 */
	public static boolean isFileExisted(String filePath)
	{
		try
		{
			File file = new File(filePath);
			if (!file.exists())
			{
				return false;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	/**
	 * �ж�Ŀ¼�Ƿ��д
	 * 
	 * @param Ŀ¼
	 * @return true��ʾ��д��false��ʾ����д
	 */
	public static boolean isDirWritable(String dir)
	{
		File file = new File(dir);
		if (!file.exists())
		{
			return false;
		}

		if (!file.isDirectory())
		{
			return false;
		}

		if (!file.canWrite())
		{
			return false;
		}

		return true;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param filePath
	 * @return true��ʾɾ���ɹ���false��ʾɾ��ʧ��
	 */
	public static boolean deleteFile(String filePath)
	{
		try
		{
			File file = new File(filePath);
			if (!file.exists())
			{
				return true;
			}

			return file.delete();
		}
		catch (Exception e)
		{
		}

		return false;
	}

	/**
	 * ��·���ĺ�����ϱ�Ҫ��б��
	 * 
	 * @param path
	 *            Ŀ¼·��
	 * @return ��·��
	 */
	public static String addSlashToPathIfNecessary(String path)
	{
		if (StringUtils.isStringNull(path))
		{
			return path;
		}

		String finalDirPath = path;
		if (!path.endsWith("/"))
		{
			finalDirPath = path + "/";
		}

		return finalDirPath;
	}

	/**
	 * д���ļ�
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @param fileContent
	 *            �ļ�����
	 * @return true��ʾд��ɹ���false��ʾʧ��
	 */
	public static boolean writeFile(String filePath, String fileContent)
	{

		FileWriter fw = null;
		try
		{
			fw = new FileWriter(filePath, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(fileContent);
			pw.close();
			fw.close();
			return true;
		}
		catch (IOException e)
		{
		}

		return false;
	}

	/**
	 * �������ļ����������µ��ļ�·��
	 * 
	 * @param filePath
	 *            �ļ�·�������磺/tmp/test.mp4
	 * @param newFormat
	 *            �����ͣ����磺flv
	 * @return ���ļ�·�������磺/tmp/test.flv
	 */
	public static String genFilePathWithNewFormat(String filePath, String newFormat)
	{
		String newFilePath = "";

		// �����ǿռ��
		if (StringUtils.isStringNull(filePath))
		{
			return newFilePath;
		}

		// �����ǿռ��
		if (StringUtils.isStringNull(filePath))
		{
			newFilePath = filePath;
			return newFilePath;
		}

		// ����ļ��Ƿ�������
		if (filePath.indexOf(".") < 0)
		{
			newFilePath = filePath + "." + newFormat;
			return newFilePath;
		}

		String filePathWithoutFormat = filePath.substring(0, filePath.lastIndexOf(".") + 1);
		newFilePath = filePathWithoutFormat + newFormat;

		return newFilePath;
	}

	/**
	 * ɾ��Ŀ¼
	 * 
	 * @param dirPath
	 *            Ŀ¼·��
	 */
	public static void deleteFolder(String dirPath)
	{
		if (StringUtils.isStringNull(dirPath))
		{
			return;
		}

		try
		{
			File folder = new File(dirPath);
			File[] files = folder.listFiles();
			if (null != files)
			{
				for (File f : files)
				{
					if (f.isDirectory())
					{
						FileUtils.deleteFolder(f.getAbsolutePath());
					}
					else
					{
						f.delete();
					}
				}
			}
			folder.delete();
		}
		catch (Exception e)
		{
		}
	}

	public static void copyFile(String oldPath, String newPath)
	{
		InputStream inStream = null;
		FileOutputStream fs = null;

		try
		{
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists())
			{
				// �ļ�����ʱ
				inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1)
				{
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("���Ƶ����ļ���������");
			e.printStackTrace();
		}
	}

	public static void moveFile(String oldPath, String newPath)
	{
		FileUtils.copyFile(oldPath, newPath);
		FileUtils.deleteFile(oldPath);
	}

	public static void newFolder(String folderPath)
	{
		try
		{
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			if (!myFilePath.exists())
			{
				myFilePath.mkdir();
			}
		}
		catch (Exception e)
		{
		}
	}

	public static void renameFile(String oldPath, String newPath)
	{
		try
		{
			File dest = null;
			if (!oldPath.equals(newPath))
			{
				File file = new File(oldPath);
				dest = new File(newPath);
				file.renameTo(dest);
			}
		}
		catch (Exception e)
		{
		}
	}

}