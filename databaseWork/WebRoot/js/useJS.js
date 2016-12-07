function createHttpRequest(method, url, callback) {
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

	httpRequest.onreadystatechange = callback;
	httpRequest.open(method, url, true);
	httpRequest.send(null);

}

function getPublicKey() {
	createHttpRequest("GET", "GetPublicKeyServlet", getPk);

}

function getPk() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			document.getElementById("publicKey").value = httpRequest.responseText;
		} else {
			alert("your request encounter wrong ." + httpRequest.responseText);
		}
	}
}

function encrypt() {
	var username = document.getElementById("username").value;
	var message = document.getElementById("message").value;
	var url = "EncryptMessageServlet?message=" + encodeURI(encodeURI(message))
			+ "&username=" + encodeURI(encodeURI(username));
	createHttpRequest("GET",url, getEncrypt);
}

function getEncrypt() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			document.getElementById("showEncrytedMessage").innerHTML = httpRequest.responseText;
		} else {
			alert("ERROR");
		}
	}
}
