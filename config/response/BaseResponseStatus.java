import lombok.Getter;

/**
 * 상태 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    /**
     * 2000 : Request 오류
     */
    BAD_REQUEST(false, 2001, "잘못된 요청입니다."),

    /**
     * 2500 : Request 성공
     */
    FILE_UPLOAD_SUCCESS(true, 2500, "파일 업로드에 성공하였습니다."),

    /**
     * 3000 : Response 오류
     */
    VALIDATED_ERROR(false, 3000, "VALIDATED_ERROR"), // @Valid 예외 처리


    /**
     * 4000 : Database, Server 오류
     */
    INTERNAL_SERVER_ERROR(false, 4000, "서버 오류입니다"),
    JSON_PROCESSING_ERROR(false, 4001, "JSON을 처리하는 과정 중 오류가 발생했습니다."),
    ENCODING_ERROR(false, 4002, "인코딩을 처리하는 과정 중 오류가 발생했습니다.");

    private final boolean success;
    private final int status;
    private final String message;

    BaseResponseStatus(boolean success, int code, String message){
        this.success = success;
        this.status = code;
        this.message = message;
    }
}
