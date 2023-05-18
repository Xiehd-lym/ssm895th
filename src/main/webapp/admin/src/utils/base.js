const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm895th/",// http://localhost:8081/ssm895th
            name: "ssm895th",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "养老院管理系统"
        } 
    }
}
export default base
