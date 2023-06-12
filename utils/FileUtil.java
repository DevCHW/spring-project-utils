import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class FileUtil {

    String fileDir;

    public void setFileDir(String fileDir) {
        this.fileDir = fildDir;
    }

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    /**
     * 파일 저장하기
     * 저장된 프로필이미지명 반환
     */
    public String save(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return null;
        }
        String fileName = createFileName(multipartFile);
        try {
            multipartFile.transferTo(new File(getFullPath(fileName)));
        } catch (IOException e) {
            throw new RuntimeException;
        }
        return fileName;
    }

    /**
     * 저장될 파일명 생성하기
     * 날짜 + nanotime + 확장자 반환
     */
    private String createFileName(MultipartFile multipartFile) {
        String ext = extractExt(multipartFile.getOriginalFilename());
        return String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance())+System.nanoTime()+"."+ext;
    }


    /**
     * 파일 확장자 알아내기
     * 파일 확장자 반환
     */
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

    /** 파일 삭제하기 */
    public void delete(String fileName) {
        String fullPath = getFullPath(fileName);

        File file = new File(fullPath);

        if(file.exists()) file.delete();    //파일이 존재한다면 파일 삭제
    }
}
