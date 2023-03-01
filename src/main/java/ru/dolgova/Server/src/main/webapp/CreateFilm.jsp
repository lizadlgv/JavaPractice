<html>
<head>
<meta charset="UTF-8">
<title>Create film</title>
</head>
<body>
<div style="font-size: 20px; text-align: center; padding: 30px; margin: 50px; border: 1px solid black; border-radius: 5px; display: flex; flex-direction: column; justify-content: center;">
<h3> Enter the data to create a film: </h3>
    <form method="post" action="film">
    <label>
        <span>ID Film: </span>
        <input type="number" name="id"/><br><br>
    </label>
    <label>
        <span>Name: </span>
        <input type="text" name="title"/><br><br>
    </label>
    <label>
        <span>Rating: </span>
        <input type="text" name="rating"/><br><br>
    </label>
    <label>
        <span>ID Director: </span>
        <input type="number" name="directorId"/><br><br>
    </label>
    <input type="submit" value="Create!" />
</div>
</body>
</html>