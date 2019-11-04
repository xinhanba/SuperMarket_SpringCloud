// 模态框显示
function show(id, s) {
    id.fadeIn(300, function() {
        $(s).show();
    });
};
// 模态框隐藏
function hide(id, d) {
    id.fadeOut(300, function() {
        $(d).hide();
    });
};
