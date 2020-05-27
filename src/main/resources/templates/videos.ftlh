<!doctype html>
<html>
<head>
    <title>${videosType}</title>
</head>
<body>
<div align="center">
    <h1>${videosType}</h1>
    <#list videos as video>
        <tr>
            <td><a href="/video/${video.id}">${video.videoName}</a></td>
            <td><a href="/video/${video.id}" target="_blank"><img src="${video.previewPath}" alt="Preview"></a></td>
            <td><a href="/video/${video.id}">${video.description}</a></td>
        </tr>
        </#list>
</div>
</body>
</html>