


console.log("Ejecutando archivo javascript admin.js")

const deleteProductButtons = document.querySelectorAll(".delete-product-button")

for (const button of deleteProductButtons){
    button.addEventListener("click", deleteProductHandler, false);
}




function deleteProductHandler(event){
    fetch(`/deleteProduct/${event.target.getAttribute("data-product-id")}`,{method : "DELETE"});
}
