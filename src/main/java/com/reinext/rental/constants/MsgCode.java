package com.reinext.rental.constants;

public enum MsgCode {

	SUCCESSFUL(200, "登録が成功しました"), 
	INPUT_ERROR(400, "入力エラー"), 
	AREA_NOT_FOUND(404,"このエリアは存在しません"),
	LINE_NOT_FOUND(404,"この路線は存在しません"),
	ADDRESS_ERROR(400,"住所エラー"),
	ADDRESS_EXISTED(400,"住所は既に存在しています"),
	STATION_EXISTED(400,"駅は既に存在しています"),
	DATA_NOT_FOUND(404,"データ存在しません")
	;

	private int code;

	private String message;


	private MsgCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
