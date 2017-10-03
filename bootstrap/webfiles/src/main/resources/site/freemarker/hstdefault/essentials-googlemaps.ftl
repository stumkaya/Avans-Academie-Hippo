<#include "../include/imports.ftl">

<#-- @ftlvariable name="componentId" type="java.lang.String" -->
<#-- @ftlvariable name="cparam" type="org.onehippo.cms7.essentials.components.info.EssentialsGoogleMapsComponentInfo" -->




<div class="component-hero location">
  <div id="googlemap"></div>
  <div class="container">
    <div class="row banner">
      <div class="col-xs-5 col-sm-4">
        <p>Hier ga je studeren</p>
      </div>
      <div class="col-xs-7 col-sm-8">

      </div>
    </div>
    <div class="row text">
      <div class="col-xs-12 col-md-4">
        <header>
          <h1>Locatie en faciliteiten</h1>
        </header>
        <div>
          <p><strong>Avans Academie</strong><br>
            Stationsplein 50<br>
            's-Hertogenbosch
          </p>
        </div>
      </div>
    </div>
  </div>
</div>

<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/bootstrap.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/jquery.cycle2.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/scrollspy.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/vendor/owl.carousel.min.js" />"></script>
</@hst.headContribution>
<@hst.headContribution category="htmlBodyEnd">
<script type="text/javascript" src="<@hst.webfile path="/js/scripts.min.js" />"></script>
</@hst.headContribution>

<@hst.headContribution keyHint="google-maps-api" category="htmlBodyEnd">
    <#assign mapsUrl = "https://maps.googleapis.com/maps/api/js?key=AIzaSyB7CfjrGrAALAEMysGf-XA9qJITmrHUZFQ&amp;callback=initMap"/>
    <script type="text/javascript" src="${mapsUrl}" async="async" defer="defer"></script>
</@hst.headContribution>

