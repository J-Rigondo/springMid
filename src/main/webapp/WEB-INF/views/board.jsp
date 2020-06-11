<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${title} | ${para}</title>

<link type="text/css" rel="stylesheet"
	href="/static/res/css/sample.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
<script type="text/javaScript" language="javascript" defer="defer">
	//등록
	function fn_regSubject(){		
		location.href = "/regSubject";
		
		}

	//상세보기
	function fn_select(id){
			location.href = "/boardDetail.do?no="+id;			
		}

	//검색
	function fn_search(){
		const type = $('#searchCondition').val();
		const keyword = $('#searchKeyword').val();
		let url =  "/selectSubjectList?searchType="+type+"&searchKeyword="+keyword;
		location.href = url;			
		}	

	//맨 앞 버튼
	function fn_head(page, range, searchType, keyword){				
		page=parseInt(page);
		range=parseInt(range);
		
		var url = "/selectSubjectList";
		url=url+"?page="+page;
		url=url+"&range="+range;
		url=url+"&searchType="+searchType;
		url=url+"&keyword="+keyword;
		location.href=url;
	}
	//맨 뒤 버튼
	function fn_tail(page, listSize, searchType, keyword){				
		page = parseInt(page);
		listSize = parseInt(listSize);
		const range = Math.ceil(page / listSize);
		
		var url = "/selectSubjectList";
		url=url+"?page="+page;
		url=url+"&range="+range;
		url=url+"&searchType="+searchType;
		url=url+"&keyword="+keyword;
		location.href=url;
	}
	//이전 버튼
	function fn_prev(page, range, rangeSize, searchType, keyword, prev){		
		if(prev === 'false')
			return;
		page=parseInt(page);
		range=parseInt(range);
		rangeSize=parseInt(rangeSize);
		
		var page=((range-2) * rangeSize) + 1;
		var range = range -1;
		
		var url = "/selectSubjectList";
		url=url+"?page="+page;
		url=url+"&range="+range;
		url=url+"&searchType="+searchType;
		url=url+"&keyword="+keyword;
		location.href=url;
	}
	//페이지 번호 클릭
	function fn_pagination(page, range, searchType, keyword){
		var url="/selectSubjectList";
		url=url+"?page="+page;
		url=url+"&range="+range;
		url=url+"&searchType="+searchType;
		url=url+"&keyword="+keyword;
		location.href=url;
	}
	//다음 버튼
	function fn_next(page, range, rangeSize, searchType, keyword , next){
		if(next === 'false')
			return;
		page=parseInt(page);
		range=parseInt(range);
		rangeSize=parseInt(rangeSize);
		
		var page=(range * rangeSize) + 1;
		var range = range +1;
		
		var url="/selectSubjectList";
		url=url+"?page="+page;
		url=url+"&range="+range;
		url=url+"&searchType="+searchType;
		url=url+"&keyword="+keyword;
		location.href=url;
	}
</script>
</head>

<body>
<div style="display:flex; justify-content:center;margin-top:2rem">
	<form id="listForm" name="listForm" action="javascript:fn_search()" method="post">
		<input type="hidden" name="selectedId" />
		<div id="content_pop">
			<!-- 타이틀 -->
			<div id="title">
				<ul>
					<li><img src="/static/res/img/title_dot.gif" alt="" />과목목록</li>
					<li>페이지 방문수: ${hit }</li>
				</ul>
			</div>
			<!-- // 타이틀 -->
			<div id="search">
				<ul>
					<li><label for="searchCondition" style="visibility: hidden;">검색어
							선택</label> <select id="searchCondition" name="searchCondition"
						class="use">
							<option value="1">과목명</option>
							<option value="0">등록자</option>
					</select></li>
					<li><label for="searchKeyword"
						style="visibility: hidden; display: none;">검색어 입력</label> <input
						id="searchKeyword" name="searchKeyword" class="txt" type="text"
						value="" /></li>
					<li><span class="btn_blue_l"> <a href="javascript:fn_search()">검색</a> <img
							src="/static/res/img/btn_bg_r.gif" style="margin-left: 6px;"
							alt="" />
					</span></li>
				</ul>
			</div>
			<!-- List -->
			<div id="table">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					summary="">
					<caption style="visibility: hidden"></caption>
					<colgroup>
						<col width="40" />
						<col width="200" />
						<col width="50" />
						<col width="80" />
						<col width="?" />
						<col width="60" />
					</colgroup>
					
			
					<tr>
						<th align="center">No</th>
						<th align="center">과목명</th>
						<th align="center">학년</th>
						<th align="center">개설여부</th>
						<th align="center">설명</th>
						<th align="center">등록자</th>
					</tr>
					
					<c:forEach var="result" items="${subjectList }" varStatus="status">
					<tr>
						<td style="cursor:pointer;" align="center" class="listtd"
						onclick="javascript:fn_select('${result.id}')"><c:out value="${result.id }"/></td>
						<td align="center" class="listtd"><c:out value="${result.subject }"/></td>
						<td align="center" class="listtd"><c:out value="${result.grade }"/></td>
						<td align="center" class="listtd"><c:out value="${result.useYn }"/></td>
						<td align="center" class="listtd"><c:out value="${result.description }"/></td>
						<td align="center" class="listtd"><c:out value="${result.regUser }"/></td>
					</tr>
				    </c:forEach>						
				</table>
			</div>
			<!-- /List -->
			<div id="paging">
				<a href="#" onclick="fn_head('${1}','${1}',
					'${pagination.searchType}','${pagination.searchKeyword}')
					">
					<image
						src=/static/res/img/btn_page_pre10.gif border=0 /></a>
						&#160;
						<a href="#" onclick="fn_prev('${idx}','${pagination.range}',
						'${pagination.rangeSize}','${pagination.searchType}','${pagination.searchKeyword}',
						'${pagination.prev}')">
						<image src=/static/res/img/btn_page_pre1.gif border=0 /></a>
						
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
						&#160;<a href="#" onclick="fn_pagination('${idx}','${pagination.range}',
							'${pagination.searchType}','${pagination.searchKeyword}')">
							<c:if test="${pagination.page eq idx }">
								<strong>${idx}</strong>
							</c:if>
							<c:if test="${pagination.page ne idx }">
								${idx}
							</c:if>
							</a>&#160;
				</c:forEach>		
						<a href="#" onclick="fn_next('${idx}','${pagination.range}',
							'${pagination.rangeSize}','${pagination.searchType}','${pagination.searchKeyword}',
							'${pagination.next}')">
						<image src=/static/res/img/btn_page_next1.gif border=0 />&#160;</a>
						
						<a href="#" onclick="fn_tail('${pagination.pageCnt}','${pagination.listSize}',
							'${pagination.searchType}','${pagination.searchKeyword}')">
						<image src=/static/res/img/btn_page_next10.gif border=0 /></a>&#160;
						 <input	id="pageIndex" name="pageIndex" type="hidden" value="1" />
			</div>
			<div id="sysbtn">
				<ul>
					<li><span class="btn_blue_l"> <a href="javascript:fn_regSubject()">등록</a> <img
							src="/static/res/img/btn_bg_r.gif" style="margin-left: 6px;"
							alt="" />
					</span></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<script>	
		
	$(function(){		
		const tag_length = ($('tr').length-1);
		const cnt = (${num} > tag_length )? tag_length : ${num};  	
	
		for(let i=0; i<tag_length - cnt; i++){
			$('tr').eq(tag_length - i).remove();
			}	
			
		});

</script>
</body>
</html>
