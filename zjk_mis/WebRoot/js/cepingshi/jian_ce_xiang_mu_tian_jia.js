/**
 * Created by pnfy on 2016/8/25.
 */
function fadeIn() {
    document.getElementById('formTable').className = 'modal';
    document.getElementById('shade').className = 'modal-backdrop';
}

function fadeOut() {
    document.getElementById('formTable').className = 'modal hide';
    document.getElementById('shade').className = 'modal-backdrop hide';
}
