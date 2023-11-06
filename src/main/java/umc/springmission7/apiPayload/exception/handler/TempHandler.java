package umc.springmission7.apiPayload.exception.handler;

import umc.springmission7.apiPayload.code.BaseErrorCode;
import umc.springmission7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {super(errorCode);}
}
