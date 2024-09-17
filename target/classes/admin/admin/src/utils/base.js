const base = {
    get() {
        return {
            url : "http://localhost:8080/duomeitisucaiku/",
            name: "duomeitisucaiku",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/duomeitisucaiku/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "多媒体素材库"
        } 
    }
}
export default base
