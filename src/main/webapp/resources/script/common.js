var common = {

    stringFilter : {

        // 匹配 url ,替换为链接
        url2Link: function (str) {
            var reg = /(http:\/\/|https:\/\/)((\w|=|\?|\.|\/|&|-)+)/g;
            var result = str.replace(reg, "<a href='$1$2'>$1$2</a>").replace(/\n/g, "<br/>");
            return result;
        }
    }
};