function searchTitle() {
    let searchTitle = $("#searchTitle").val();
    $.ajax({
        url: "http://localhost:8080/api/blog/searchTitle",
        data: {
            searchTitle: searchTitle
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `

             <div class="box">
                <div class="column">
                    <div class="card">
                        <h3  class="card-title">${response[i].title}</h3>

                        <span style="display: inline; font-size: 18px; color: grey; font-style: italic ; text-align: left; margin-left: 3px">Category:
                            <span  class=" theme card-subtitle mb-2 text-muted ml-2 ">
                                        ${ response[i].category.nameTheme}
                              </span>
                            <span style="float: right; margin-right: 3px" >
                                     ${response[i].dateWrite}
                               </span>
                        </span>

                        <div class="card-body" style="height: 100px; width: 100%;  display:block; margin: 0 ">
                            <h6> ${response[i].content}</h6>
                        </div>

                        <div style="margin-bottom: 10px; margin-top: 10px">
                            <ul class="exam-container">
                                <li class="exam-element flex-grow-ele1" style="flex-grow: 5;">
                                    <a th:href="@{/blogs/detail(id=${response[i].id})}">
                                        <button class="btn btn-primary btn-lg"
                                                style="background: orange;color: white; width: 80px"> Xem
                                        </button>
                                    </a>
                                </li>

                                <li class="exam-element flex-grow-ele2" style="flex-grow: 5;">
                                    <a>
                                        <button
                                                onclick="showModelDelete( ${response[i].id} ,${response[i].title})"
                                                class="btn btn-primary btn-lg"
                                                style="background: orange;color: white; width: 80px"
                                                data-toggle="modal"
                                                data-target="#modalDelete">
                                            Xóa
                                        </button>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });
}


function deleteBlog () {
    let idDelete = $("#idDelete").val();
    $.ajax({
        url: "http://localhost:8080/api/blog/delete",
        data: {
            idDelete: idDelete
        },
        type: "delete",
        dataType: "json",
        success: function (response) {
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `

             <div class="box">
                <div class="column">
                    <div class="card">
                        <h3  class="card-title">${response[i].title}</h3>

                        <span style="display: inline; font-size: 18px; color: grey; font-style: italic ; text-align: left; margin-left: 3px">Category:
                            <span  class=" theme card-subtitle mb-2 text-muted ml-2 ">
                                        ${ response[i].category.nameTheme}
                              </span>
                            <span style="float: right; margin-right: 3px" >
                                     ${response[i].dateWrite}
                               </span>
                        </span>

                        <div class="card-body" style="height: 100px; width: 100%;  display:block; margin: 0 ">
                            <h6> ${response[i].content}</h6>
                        </div>

                        <div style="margin-bottom: 10px; margin-top: 10px">
                            <ul class="exam-container">
                                <li class="exam-element flex-grow-ele1" style="flex-grow: 5;">
                                    <a th:href="@{/blogs/detail(id=${response[i].id})}">
                                        <button class="btn btn-primary btn-lg"
                                                style="background: orange;color: white; width: 80px"> Xem
                                        </button>
                                    </a>
                                </li>

                                <li class="exam-element flex-grow-ele2" style="flex-grow: 5;">
                                    <a>
                                        <button
                                                onclick="showModelDelete( ${response[i].id} ,${response[i].title})"
                                                class="btn btn-primary btn-lg"
                                                style="background: orange;color: white; width: 80px"
                                                data-toggle="modal"
                                                data-target="#modalDelete">
                                            Xóa
                                        </button>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

                `;

                // result += "<tr>"
                //     + "<td>"+ response[i].subjectId + "</td>"
            }
            $("#result").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });

}