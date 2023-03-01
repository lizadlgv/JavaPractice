<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="charset" content="windows-1251">
<title>Create director</title>
</head>
<body>
<div  style="font-size: 20px; text-align: center; padding: 30px; margin: 50px; border: 1px solid black; border-radius: 5px; display: flex; flex-direction: column; justify-content: center;">
<h3> Enter the data to create a director:</h3>
    <form method="post" action="director">
    <label>
        <span>ID Director: </span>
        <input type="number" name="directorId"/><br><br>
    </label>
    <label>
        <span>Name: </span>
        <input type="text" name="name"/><br><br>
    </label>
    <label>
        <span>Last Name: </span>
        <input type="text" name="secondName"/><br><br>
    </label>
    <label>
        <span>BDay: </span>
        <input type="date" name="BDay"/><br><br>
    </label>
    <label>
        <span>Sex: </span>
        <input type="text" name="sex"/><br><br>
    </label>
    <input type="submit" value="Create!" />
</div>
</body>
</html>