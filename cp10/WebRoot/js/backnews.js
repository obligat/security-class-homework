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


function getOtherPubKey() {
	var username = document.getElementById("othername").value;
	var url = "GetOtherPublicKey?username=" + encodeURI(username);
	createHttpRequest("GET", url, getOtherResult);
}

function getOtherResult() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			document.getElementById("pubKey").innerHTML = httpRequest.responseText;
		} else {
			alert("ERROR");
		}
	}
}