function createHttpRequest() {
	httpRequest = false;
	if (window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			httpRequest = new ActiveXObject("Msxm12.XMLHTTP");
		} catch (e) {
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}

	}

	if (!httpRequest) {
		alert("can not create XMLHttpRequest object .");
		return false;
	}

	return httpRequest;

}

function getPublicKey() {
	httpRequest = false;
	if (window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			httpRequest = new ActiveXObject("Msxm12.XMLHTTP");
		} catch (e) {
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}

	}

	if (!httpRequest) {
		alert("can not create XMLHttpRequest object .");
		return false;
	}
	httpRequest.onreadystatechange = getPk;
	httpRequest.open("GET", "GetKey", true);
	httpRequest.send(null);
}

function getPk() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			document.getElementById("publicKey").value = httpRequest.responseText;
		} else {
			alert("your request encounter wrong ."+httpRequest.responseText);
		}
	}
}

function encrypt() {

}