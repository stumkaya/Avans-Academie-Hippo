<#include "../include/imports.ftl">

<#macro cookiebox>
    <@hst.setBundle basename="essentials.global"/>
<div class="cookie-box" id="cookie-box">
  <div class="container">
    <div class="row">
      <div class="col-xs-12">
          <@fmt.message key="cookie.text" var="cookietext"/>${cookietext}
        <a href="#" class="cookie-toggle white">
          <svg xmlns="http://www.w3.org/2000/svg" class="svg svg-close">
            <g>
              <g class="a">
                <g class="b">
                  <path d="m15,12.2l-9.2,-9.2l-2.8,2.8l9.2,9.2l-9.2,9.2l2.8,2.8l9.2,-9.2l9.2,9.2l2.8,-2.8l-9.2,-9.2l9.2,-9.2l-2.8,-2.8l-9.2,9.2z"/>
                </g>
              </g>
            </g>
          </svg>
        </a>
      </div>
    </div>
  </div>
</div>
</#macro>