/**
 * Created by wetsaid on 2016/6/14.
 */
var updateObj = function (id) {
    window.location = "course!goToUpdate.action?courseId=" + id;
}
var deleteObj = function (id) {
    if (confirm("确认要删除此课程吗?")) {
        window.location = "course!deleteCourse.action?courseId=" + id;
    }
}

function getCourseType() {
    var value = document.getElementById("types").value
    document.getElementById("code").value = value
}
var deleteCourse = function (id) {
    if (confirm("确认要退选此课程吗?")) {
        window.location = "chooseCourse!deleteChooseCourse.action?courseId=" + id;
    }
}

function check() {
    document.getElementById("types").value = "${type}"
}