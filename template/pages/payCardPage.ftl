
  <div class="row justify-content-md-center">
    <div class="col-12 col-md-5 col-lg-6">
      <div class="row" style="margin-top: 20px;">
        <div class="col-12">
          <p class="title-network">Chọn nhà mạng:</p>
        </div>
      </div>
      <div class="w-100"></div>
      <div class="col mobile-only padding-0">
        <select class="custom-select mobile-select-telco">
          <option value="">Nhà mạng</option>
          <option value="MOBI">MOBIFONE</option>
          <option value="VINA">VINAPHONE</option>
          <option value="VT">VIETTEL</option>
        </select>
      </div>
      <div class="row text-center desktop-only">
        <div class="col">
          <div class="btn-network btn-mobi" data-telco="MOBI">
            <img src="${root_url}img/mobi.png" class="img-fluid" alt="">
          </div>
        </div>
        <div class="col">
          <div class="btn-network btn-vina" data-telco="VINA">
            <img src="${root_url}img/vina.png" class="img-fluid" alt="">
          </div>
        </div>
        <div class="col">
          <div class="btn-network btn-viettel" data-telco="VT">
            <img src="${root_url}img/viettel.png" class="img-fluid" alt="">
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <em class="warning-network">*Lưu ý: Tỷ giá trên chỉ áp dụng với thuê bao <span class="name-network">MOBIFONE</span></em>
        </div>
      </div>
      <div class="row" style="margin-top: 20px;">
        <div class="col">
          <p class="title-network">Mã thẻ:</p>
        </div>
        <div class="w-100"></div>
        <div class="col">
          <input type="text" class="form-control input-border-radius" id="card_code">
        </div>
      </div>
      <div class="row" style="margin-top: 20px;">
        <div class="col">
          <p class="title-network">Số Serial: </p>
        </div>
        <div class="w-100"></div>
        <div class="col">
          <input type="text" class="form-control input-border-radius" id="card_serial">
        </div>
      </div>
      <div class="row justify-content-end" style="margin-top: 25px;">
        <!-- <div class="col col-lg-4">
          <div class="btn-back">QUAY LẠI</div>
        </div> -->
        <div class="col-6 col-lg-4">
          <div class="btn-send-sms">GỬI</div>
        </div>
      </div>
    </div>

    <div class="col-12 col-md-7 col-lg-6 table-exchange">
      <div class="row table-striped-custom">
        <div class="col-3 th-table-exchange" style="border-top-left-radius: 10px;">Mệnh Giá</div>
        <div class="col-3 text-center th-table-exchange line-left-right">Khuyến Mãi</div>
        <div class="col-6 text-right th-table-exchange" style="border-top-right-radius: 10px;">Ncoin</div>
        <#if info_card??>
          <#list info_card as item>
            <#if item.productType == "CARD">
              <div class="w-100"></div>
              <div class="col-3 item-table-exchange format-money">${item.amount}</div>
              <#if item.promotionRate != 0>
                <div class="col-3 text-center item-table-exchange line-left-right" style="color: red">${item.promotionRate} %</div>
                <div class="col-6 text-right item-table-exchange" style="color: red"><del class="format-money">${item.nCoin}</del> - <span class="format-money">${item.nCoin?number * item.promotionRate?number / 100 + item.nCoin?number}</span></div>
              <#else>
                <div class="col-3 text-center item-table-exchange line-left-right">${item.promotionRate} %</div>
                <div class="col-6 text-right item-table-exchange format-money">${item.nCoin}</div>
              </#if>
            </#if>
          </#list>
        <#else>
          <div class="w-100"></div>
          <div class="col item-table-exchange">No Data</div>
        </#if>
        <div class="w-100"></div>
        <div class="col-3 item-table-exchange" style="border-bottom-left-radius: 10px;"></div>
        <div class="col-3 text-center item-table-exchange line-left-right"></div>
        <div class="col-6 text-right item-table-exchange" style="border-bottom-right-radius: 10px;"></div>
      </div>
    </div>
  </div>
  <script src="${root_url}custom/js/payCardPage.js"></script>
