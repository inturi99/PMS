<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link href="./resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<script src="./resources/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="./resources/js/jquery.dataTables.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="./resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
	href="./resources/css/jquery.dataTables.min.css">
<title>jQuery Tabulate Plugin Demo</title>
<script type="text/javascript">

$(document).ready(function() {
	var obj ="jtStartIndex=0&jtPageSize=16";
	var myUrl = "http://localhost:8000/PMS/usertable/getAllUsers?jtStartIndex=0&jtPageSize=16";
	var myVarible=[];
	$('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": myUrl,
        "columns": [
            { "data": "UserId" },
            { "data": "UserName" },
            { "data": "Dob" },
            { "data": "CountryId" },
            { "data": "StateId" }
           ]
	});
} );
</script>

</head>

<body>
	<div id="jquery-script-menu">
	</div>
	<h1 style="margin-top: 150px;">User List</h1>
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>UserId</th>
                <th>UserName</th>
                <th>Dob</th>
                <th>CountryId</th>
                <th>StateId</th>
                 </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>UserId</th>
                <th>UserName</th>
                <th>Dob</th>
                <th>CountryId</th>
                <th>StateId</th>
               
            </tr>
        </tfoot>
    </table>
</body>
</html>
