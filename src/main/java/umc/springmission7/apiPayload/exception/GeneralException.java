package umc.springmission7.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.springmission7.apiPayload.code.BaseErrorCode;
import umc.springmission7.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;
    private ErrorReasonDTO getErrorReason() {return this.code.getReason();}
    public ErrorReasonDTO getErrorReasonHttpStatus() {return this.code.getReasonHttpStatus();}
}
