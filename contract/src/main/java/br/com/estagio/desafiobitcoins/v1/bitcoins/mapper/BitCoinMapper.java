package br.com.estagio.desafiobitcoins.v1.bitcoins.mapper;

import br.com.estagio.desafiobitcoins.coin.criteria.ImplCriteria;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.*;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.v1.bitcoins.criteria.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BitCoinMapper {

    public List<BitCoinCompleteResponse> mapToBitCoinCompleteResponseList(List<BitCoinsDescription> list){
        List<BitCoinCompleteResponse> listResponse = new ArrayList<>();
        for(BitCoinsDescription b:list) {
            listResponse.add(mapToBitCoinCompleteResponse(b));
        }
        return listResponse;
    }

    public BitCoinSimpleResponse mapToBitCoinSimpleResponse(BitCoinsDescription bitCoinsDescription){
        return BitCoinSimpleResponse.builder()
                .id(bitCoinsDescription.getId())
                .isActive(bitCoinsDescription.getIsActive())
                .ene(bitCoinsDescription.getEne())
                .name(bitCoinsDescription.getName())
                .rank(bitCoinsDescription.getRank())
                .symbol(bitCoinsDescription.getSymbol())
                .type(bitCoinsDescription.getType())
                .build();
    }

    public List<BitCoinSimpleResponse> mapToBitCoinSimpleResponseList(List<BitCoinsDescription> list){
        List<BitCoinSimpleResponse> listResponse = new ArrayList<>();
        for(BitCoinsDescription b:list) {
            listResponse.add(BitCoinSimpleResponse.builder()
                        .id(b.getId())
                        .isActive(b.getIsActive())
                        .ene(b.getEne())
                        .name(b.getName())
                        .rank(b.getRank())
                        .symbol(b.getSymbol())
                        .type(b.getType())
                        .build());
        }
        return listResponse;
    }

    public BitCoinCompleteResponse mapToBitCoinCompleteResponse(BitCoinsDescription bitCoinsDescription){
        return BitCoinCompleteResponse.builder()
                .description(bitCoinsDescription.getDescription())
                .developmentStatus(bitCoinsDescription.getDevelopmentStatus())
                .firstDatAat(bitCoinsDescription.getFirstDataAt())
                .hardWreWallet(bitCoinsDescription.getHardwareWallet())
                .hashAlgorithm(bitCoinsDescription.getHashAlgorithm())
                .id(bitCoinsDescription.getId())
                .isActive(bitCoinsDescription.getIsActive())
                .ene(bitCoinsDescription.getEne())
                .lastDatAat(bitCoinsDescription.getLastDataAt())
                .message(bitCoinsDescription.getMessage())
                .name(bitCoinsDescription.getName())
                .openSource(bitCoinsDescription.getOpenSource())
                .orgStructure(bitCoinsDescription.getOrgStructure())
                .proofType(bitCoinsDescription.getType())
                .rank(bitCoinsDescription.getRank())
                .startEDat(bitCoinsDescription.getStartedAt())
                .symbol(bitCoinsDescription.getSymbol())
                .tags(bitCoinsDescription.getTags())
                .team(bitCoinsDescription.getTeam())
                .type(bitCoinsDescription.getType())
                .prices(bitCoinsDescription.getPrices())
                .build();
    }

    public ImplCriteria mapToImplCriteria(Criteria criteria){
        return ImplCriteria.builder()
                .id(criteria.getId())
                .name(criteria.getName())
                .symbol(criteria.getSymbol())
                .rankGreaterThan(criteria.getRankGreaterThan())
                .rankLessThan(criteria.getRankLessThan())
                .marketCapGreaterThan(criteria.getMarketCapGreaterThan())
                .marketCapLessThan(criteria.getMarketCapLessThan())
                .build();
    }
}
