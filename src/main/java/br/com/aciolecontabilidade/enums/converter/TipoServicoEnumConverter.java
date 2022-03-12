package br.com.aciolecontabilidade.enums.converter;

import javax.persistence.AttributeConverter;

import br.com.aciolecontabilidade.enums.TipoServicoEnum;

public class TipoServicoEnumConverter implements AttributeConverter<TipoServicoEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoServicoEnum tipoServicoEnum) {
		return tipoServicoEnum != null ? tipoServicoEnum.getId() : null;
	}

	@Override
	public TipoServicoEnum convertToEntityAttribute(Integer idTipoServicoEnum) {
		for (TipoServicoEnum tqe : TipoServicoEnum.values()) {
			if (tqe.getId().equals(idTipoServicoEnum)) {
				return tqe;
			}
		}
		return null;
	}

}
