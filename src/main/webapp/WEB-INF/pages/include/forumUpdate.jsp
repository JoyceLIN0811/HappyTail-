<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="topic-tab" data-toggle="tab" href="#topic" role="tab" aria-controls="topic" aria-selected="true">My Topic</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="follow-tab" data-toggle="tab" href="#follow" role="tab" aria-controls="follow" aria-selected="false">My Follow List</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="like-tab" data-toggle="tab" href="#like" role="tab" aria-controls="like" aria-selected="false">My Like Topic</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="history-tab" data-toggle="tab" href="#history" role="tab" aria-controls="history" aria-selected="false">My Read History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="favorate-tab" data-toggle="tab" href="#favorate" role="tab" aria-controls="favorate" aria-selected="false">Favorate Category</a>
  </li>
</ul>
<div class="tab-content" id="forum-tab-content">
  <div class="tab-pane fade show active" id="topic" role="tabpanel" aria-labelledby="topic-tab">
	<!--   TODO : use memberCenterTemplate[id="myTopic"] here -->
  </div>
  <div class="tab-pane fade" id="follow" role="tabpanel" aria-labelledby="follow-tab">
  	<!--   TODO : use memberCenterTemplate[id="myFollowList"] here -->
  </div>
  <div class="tab-pane fade" id="like" role="tabpanel" aria-labelledby="like-tab">
	<!--   TODO : use memberCenterTemplate[id="myLikeTopic"] here -->
  </div>
  <div class="tab-pane fade" id="history" role="tabpanel" aria-labelledby="history-tab">
	<!--   TODO : use memberCenterTemplate[id="myReadHistory"] here -->
  </div>
  <div class="tab-pane fade" id="favorate" role="tabpanel" aria-labelledby="favorate-tab">
      <div class="row mt-5">
          <div class="col-4"></div>
          <div class="col-4">
              <div class="list-group">
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>生活</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>資訊</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>新聞</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>認養</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>發問</h5></button>
                  <button type="button" class="text-center list-group-item list-group-item-action " onclick="toggleActive(this)"><h5>其他</h5></button>
              </div>
              <button type="button" class="btn btn-primary btn-lg btn-block mt-3">
                 	 更新喜好類別
              </button>
          </div>

          <div class="col-4"></div>
      </div>
  </div>
</div>